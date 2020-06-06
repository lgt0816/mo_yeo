package com.sungkyul.graduation.service;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sungkyul.graduation.controller.ActivityController;
import com.sungkyul.graduation.controller.FileController;
import com.sungkyul.graduation.domain.Activity;
import com.sungkyul.graduation.domain.ActivityFile;
import com.sungkyul.graduation.domain.ActivityPlan;
import com.sungkyul.graduation.domain.ActivityPlanStatus;
import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.dto.ActivityModifyFormDTO;
import com.sungkyul.graduation.persistence.ActivityDAO;
import com.sungkyul.graduation.util.Aes256;

@Service
public class ActivityServiceImple implements ActivityService{

	@Inject private ActivityDAO activityDAO;
	@Inject private Aes256 aes256;
	@Inject private FileController fileController;
	
	private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImple.class);
	
	//자신의 완료된 활동 리스트를 가져옴(학년별로 정리해서)
	@Override
	public Map<Integer, List<CompletedActivity>> getActivitys(String userId, String activityType) {
		Map<Integer, List<CompletedActivity>> resultMap = new HashMap<Integer, List<CompletedActivity>>();
		logger.info("getActivitys 실행");
		
		//4학년 까지완료된 활동들을 가져옴 (i는 활동이 완료된시점의 사용자의 학년을 의미)
		for(int i=1 ;i<5;i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", userId);
			paramMap.put("activityType", activityType);
			paramMap.put("grade", i);
			
			List<CompletedActivity> activitys 
				= activityDAO.selectActivitys(paramMap);
			//활동 id를 암호화 후 url형식으로 인코딩(변수명 : encodedId)
			for(int inCoun=0; inCoun<activitys.size();inCoun++) {
				aes256.encodingActivity(activitys.get(inCoun));
			}
			resultMap.put(i, activitys);
			
			System.out.println(resultMap.get(i).toString());
		}
		
		return resultMap;
	}

	//완료된 활동 내용을 가져옴
	@Override
	public Activity getActivity(String loginedUserId, String encodedId) {
		
		try {
			String decodedId;
			Map<String, Object> paramMap = new HashMap<String, Object>();
			List<ActivityPlan> activityPlans;
			decodedId = aes256.decrypt(encodedId);
			paramMap.put("userId", loginedUserId);
			paramMap.put("activityId", decodedId);
			
			//활동 계획들을 가져옴
			activityPlans = activityDAO.selectActivityPlans(decodedId);
			for(int i=0; i<activityPlans.size();i++) {
				Map<String, Object> _paramMap = new HashMap<String, Object>();
				_paramMap.put("userId", loginedUserId);
				_paramMap.put("activityId", decodedId);
				_paramMap.put("activityPlanId", activityPlans.get(i).getPlanId());
				
				//활동계획들에 자신이 작성한 진행 상황들을 가져와서 활동계획에 넣어줌
				List<ActivityPlanStatus> activityPlanStatusList = 
						activityDAO.selectActivityPlanStatusList(_paramMap);
				activityPlans.get(i).setPlanStatusList(activityPlanStatusList);
			}
			//파일들을 가져옴
			ArrayList<ActivityFile> activityFiles =(ArrayList<ActivityFile>)activityDAO.selectActivityFiles(paramMap); 
			for(int j=0;j<activityFiles.size();j++) {
				//파일 갯수만큼 암호화후 URL형식으로 변환
				aes256.encodingFile(activityFiles.get(j));
			}
			//완료된 활동을 가져와서 필요한 데이터들을 넣어줌
			CompletedActivity resultActivity = activityDAO.selectActivity(paramMap);
			resultActivity.setParticipants((ArrayList<String>) activityDAO.selectParticipants(paramMap));//참여자 리스트를 넣어줌
			resultActivity.setActivityResult(activityDAO.selectActivityResult(paramMap));
			resultActivity.setActivityPlans(activityPlans);
			resultActivity.setFiles(activityFiles);
			
			aes256.encodingActivity(resultActivity);
			
			logger.info("resultActivity {}", resultActivity.toString());
			
			return resultActivity;
		}catch(Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}
	
	
	@Override
	public boolean updateActivityResult(ActivityModifyFormDTO activityModifyFormDTO,
			String userId) {
		try {
			String urlEncodedId = activityModifyFormDTO.getEncodedId();
			String encodedId = URLDecoder.decode(urlEncodedId, "UTF-8");
			String activityId = aes256.decrypt(encodedId);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", userId);
			paramMap.put("activityId", activityId);
			
			//결과와 소감을 처음쓰는거면 insert, 아니면 update문을 수행함
			if(activityDAO.selectOneResult(paramMap)==null) { 
				paramMap.put("result", activityModifyFormDTO.getResult());
				paramMap.put("thought", activityModifyFormDTO.getThought());
				
				return activityDAO.insertResult(paramMap);
			}
			else {
				paramMap.put("result", activityModifyFormDTO.getResult());
				paramMap.put("thought", activityModifyFormDTO.getThought());
				return activityDAO.updateResult(paramMap);
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<CompletedActivity> getAllActivity(String userId){
		List<CompletedActivity> activitys = 
				activityDAO.selectAllActivitys(userId);
		
		for(int i=0 ; i<activitys.size();i++) {
			aes256.encodingActivity(activitys.get(i));
		}
		
		return activitys;
	}

	
	//파일 업로드
	@Override
	public boolean uploadActivityFiles(String userId, ActivityModifyFormDTO activityModifyFormDTO) {
		try {
			String UrlEncodedACTId = activityModifyFormDTO.getEncodedId();
			String encodedACTId = URLDecoder.decode(UrlEncodedACTId, "UTF-8");
			String activityId = aes256.decrypt(encodedACTId);
			List<MultipartFile> realFiles = activityModifyFormDTO.getFiles();
			String activityType = activityModifyFormDTO.getActivityType();
			String activityTitle = activityModifyFormDTO.getActivityTitle();
			
			if(realFiles!= null) {
				for(int i=0; i<realFiles.size();i++) {
					MultipartFile __realFile = realFiles.get(i);
					if(!__realFile.getOriginalFilename().equals("") && 
							__realFile.getSize()!=0) {
						
						//데이터베이스에 파일정보 저장
						Map<String, Object> ___paramMap = new HashMap<String, Object>();
						___paramMap.put("userId", userId);
						___paramMap.put("activityId", activityId);
						___paramMap.put("fileName", __realFile.getOriginalFilename());
						___paramMap.put("filePath", createFilePath(userId, activityType, activityTitle));
						___paramMap.put("fileSize", __realFile.getSize());
						//데이터베이스에 파일정보 저장성공하면 FTP서버로 파일 업로드
						if(activityDAO.insertActivityFile(___paramMap)) {
							fileController.ftpConnect();
							fileController.ftpFileUpload(createFilePath(userId, activityType, activityTitle)
									, __realFile.getOriginalFilename(), __realFile.getInputStream());
							fileController.ftpDisconnect();
						}
					}
				}
			}
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//파일 경로 생성
	public String createFilePath(String userId, String activityType, String activityTitle) {
		String filePath= FileController.FTP_MAIN_PATH+"/"+userId+"/"+activityType+"/"+activityTitle+"/";
		
		return filePath;
	}



}
