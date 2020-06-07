package com.sungkyul.graduation.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sungkyul.graduation.controller.ActivityController;
import com.sungkyul.graduation.domain.ActivityFile;
import com.sungkyul.graduation.domain.ActivityPlan;
import com.sungkyul.graduation.domain.ActivityPlanStatus;
import com.sungkyul.graduation.domain.ActivityResult;
import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.dto.ActivityModifyFormDTO;

@Repository
public class ActivityDAOImpl implements ActivityDAO {

	@Inject
	private SqlSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(ActivityDAOImpl.class);
	
	private static final String NS = "com.sungkyul.graduation.persistence.ActivityMapper";
	private static final String SELECT_ACTIVITYS = NS+".selectActivitys";
	private static final String SELECT_ACTIVITY = NS+".selectActivity";
	private static final String SELECT_PARTICIPANTS = NS+".selectParticipants";
	private static final String SELECT_ONE_RESULT = NS+".selectOneResult";
	private static final String INSERT_RESULT = NS+".insertResult";
	private static final String UPDATE_RESULT = NS+".updateResult";
	private static final String SELECT_ALL_ACTIVITYS = NS+".selectAllActivitys";
	private static final String SELECT_ACTIVITY_RESULT=NS+".selectActivityResult";
	private static final String SELECT_ACTIVITY_PLANS =NS+".selectActivityPlans";
	private static final String SELECT_ACTIVITY_PLAN_STATUS_LIST=NS+".selectActivityPlanStatusList";
	private static final String INSER_ACTIVITY_FILE=NS+".insertActivityFile";
	private static final String SELECT_ACTIVITY_FILES=NS+".selectActivityFiles";
	private static final String SELECT_ACTIVITY_FILE=NS+".selectActivityFile";
	private static final String DELETE_ACTIVITY_FILE=NS+".deleteActivityFile";
	
	@Override
	public List<CompletedActivity> selectActivitys(Map<String, Object> paramMap) {
		List<CompletedActivity> resultActivity 
			= session.selectList(SELECT_ACTIVITYS, paramMap);
		logger.info("selected Activitys :{}", resultActivity.toString());
		
		return resultActivity; 
	}

	@Override
	public CompletedActivity selectActivity(Map<String, Object> paramMap) {
		CompletedActivity resultActivity 
			= session.selectOne(SELECT_ACTIVITY, paramMap);
		return resultActivity;
	}

	@Override
	public List<String> selectParticipants(Map<String, Object> paramMap) {
		List<String> resultParticipants =
				session.selectList(SELECT_PARTICIPANTS, paramMap);
		return resultParticipants;
	}
	
	
	@Override
	public Map<String, Object> selectOneResult(Map<String, Object> paramMap){
		Map<String, Object> result = 
				session.selectOne(SELECT_ONE_RESULT, paramMap);
		
		return result;
	}

	@Override
	public boolean insertResult(Map<String, Object> paramMap) {
		
		return (session.insert(INSERT_RESULT, paramMap)==0) ? false:true;
		
	}

	@Override
	public boolean updateResult(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		
		return (session.update(UPDATE_RESULT, paramMap)==0) ? false:true;
	}
	
	
	@Override
	public List<CompletedActivity> selectAllActivitys(String userId) {
		List<CompletedActivity> result = 
				session.selectList(SELECT_ALL_ACTIVITYS, userId);
		
		return result;
	}

	
	//활동결과 가져오기
	@Override
	public ActivityResult selectActivityResult(Map<String, Object> paramMap) {
		ActivityResult result = session.selectOne(SELECT_ACTIVITY_RESULT,paramMap);
		
		return result;
	}

	//활동 계획들 가져오기
	@Override
	public List<ActivityPlan> selectActivityPlans(String activityId) {
		List<ActivityPlan> result = session.selectList(SELECT_ACTIVITY_PLANS, activityId);
		return result;
	}

	//paramMap : userId, activityId, activityPlanId
	@Override
	public List<ActivityPlanStatus> selectActivityPlanStatusList(Map<String, Object> paramMap) {
		List<ActivityPlanStatus> result = 
				session.selectList(SELECT_ACTIVITY_PLAN_STATUS_LIST, paramMap);
		return result;
	}
	
	
	
	//paramMap : userId, activityId, fileName, filePath, fileSize
	@Override
	public boolean insertActivityFile(Map<String, Object> paramMap) {
		
		return (session.insert(INSER_ACTIVITY_FILE, paramMap)==0) ? false: true;
	}
	
	//paramMap : userId, activityId
	@Override
	public List<ActivityFile> selectActivityFiles(Map<String, Object> paramMap){
		List<ActivityFile> result = 
				session.selectList(SELECT_ACTIVITY_FILES, paramMap);
		
		return result;
	}
	
	//paramMap : fileId
	@Override
	public ActivityFile selectActivityFile(String fileId) {
		ActivityFile result = session.selectOne(SELECT_ACTIVITY_FILE,fileId);
		
		return result;
	}
	//paramMap : fileId, userId
	@Override
	public boolean deleteActivityFile(Map<String, Object> paramMap) {
		return (session.delete(DELETE_ACTIVITY_FILE, paramMap)==0)? false: true;
	}
	
	
}
