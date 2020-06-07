package com.sungkyul.graduation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.text.Document;
import com.sungkyul.graduation.domain.Activity;
import com.sungkyul.graduation.domain.ActivityFile;
import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.dto.ActivityModifyFormDTO;
import com.sungkyul.graduation.service.ActivityService;
import com.sungkyul.graduation.staticNamesInterface.SessionNames;


@Controller
public class ActivityController extends com.sungkyul.graduation.controller.Controller implements SessionNames {

	public static final String ACTIVITY_TYPE_STUDY = "스터디";
	public static final String ACTIVITY_TYPE_INTERNATIONAL = "공모전";
	public static final String ACTIVITY_TYPE_GRADUATION = "졸업작품";
	public static final String ACTIVITY_TYPE_PROJECT = "프로젝트";

	private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);
	@Inject	private ActivityService activityService;
	@Inject private FileController fileController;

	// 스터디 리스트 보기
	@GetMapping("/activity/completedStudys")
	public String completedStudyList(HttpServletRequest request, Model model) {
		String loginedUserId = getLoginedUserId(request);
		logger.info("loginedUserId {}", loginedUserId);

		// key : 활동완료시점의 사용자 학년 , value : 해당학년의 완료된 활동 리스트
		Map<Integer, List<CompletedActivity>> activitys = activityService.getActivitys(loginedUserId,
				ACTIVITY_TYPE_STUDY);

		model.addAttribute("map", activitys);

		return "completedActivitys";
	}

	// 대외활동 리스트 보기
	@GetMapping("/activity/completedInternationals")
	public String completedInternatinalList(HttpServletRequest request, Model model) {
		String loginedUserId = getLoginedUserId(request);
		logger.info("loginedUserId {}", loginedUserId);

		// key : 활동완료시점의 사용자 학년 , value : 해당학년의 완료된 활동 리스트
		Map<Integer, List<CompletedActivity>> activitys = activityService.getActivitys(loginedUserId,
				ACTIVITY_TYPE_INTERNATIONAL);

		model.addAttribute("map", activitys);

		return "completedActivitys";
	}

	// 프로젝트 리스트 보기
	@GetMapping("/activity/completedProjects")
	public String completedProjectList(HttpServletRequest request, Model model) {
		String loginedUserId = getLoginedUserId(request);
		logger.info("loginedUserId {}", loginedUserId);

		// key : 활동완료시점의 사용자 학년 , value : 해당학년의 완료된 활동 리스트
		Map<Integer, List<CompletedActivity>> activitys = activityService.getActivitys(loginedUserId,
				ACTIVITY_TYPE_PROJECT);

		model.addAttribute("map", activitys);

		return "completedActivitys";
	}

	// 졸업작품 리스트 보기
	@GetMapping("/activity/completedGraduations")
	public String completedGraduationList(HttpServletRequest request, Model model) {
		String loginedUserId = getLoginedUserId(request);
		logger.info("loginedUserId {}", loginedUserId);

		// key : 활동완료시점의 사용자 학년 , value : 해당학년의 완료된 활동 리스트
		Map<Integer, List<CompletedActivity>> activitys = activityService.getActivitys(loginedUserId,
				ACTIVITY_TYPE_GRADUATION);

		model.addAttribute("map", activitys);

		return "completedActivitys";
	}

	// 활동 상세 보기
	@GetMapping("/activity/detail")
	public String completedStudyItem(@RequestParam("activityId") String activityId, HttpServletRequest request,
			Model model) {
		logger.info("받은 파라미터값 {}", activityId);
		String loginedUserId = getLoginedUserId(request);
		String activityType;
		String goListUrl = "/activity/";

		Activity activity = activityService.getActivity(loginedUserId, activityId);
		logger.info("activity {}", activity.toString());

		activityType = activity.getActivityType();
		switch (activityType) {
		case ACTIVITY_TYPE_STUDY:
			goListUrl += "completedStudys";
			break;
		case ACTIVITY_TYPE_INTERNATIONAL:
			goListUrl += "completedInternationals";
			break;
		case ACTIVITY_TYPE_PROJECT:
			goListUrl += "completedProjects";
			break;
		case ACTIVITY_TYPE_GRADUATION:
			goListUrl += "completedGraduations";
			break;
		}

		model.addAttribute("activity", activity);
		model.addAttribute("goListUrl", goListUrl);

		return "activityDetail";
	}

	// 스터디 수정하기 화면 (파일 추가 안되있음)
	@GetMapping("/activity/modify")
	public String modifyStudyItemGet(@RequestParam("activityId") String activityId, HttpServletRequest request,
			Model model) {
		String loginedUserId = getLoginedUserId(request);
		Activity activity = activityService.getActivity(loginedUserId, activityId);

		model.addAttribute("activity", activity);

		return "activityModify";
	}

	// 스터디 수정하기 비지니스 로직
	@PostMapping("/activity/modifyPost")
	public String modifyStudyItemPost(HttpServletRequest request,
			@ModelAttribute(name = "actModifyDTO") ActivityModifyFormDTO activityModifyFormDTO,
			RedirectAttributes redirect) throws UnsupportedEncodingException {
		String loginedUserId = getLoginedUserId(request);
		String urlEncodedId = activityModifyFormDTO.getEncodedId();
		String encodedId = URLDecoder.decode(urlEncodedId, "UTF-8");
		List<MultipartFile> realFiles = activityModifyFormDTO.getFiles();
		
		if(activityService.uploadActivityFiles(loginedUserId, activityModifyFormDTO)) {
			if (activityService.updateActivityResult(activityModifyFormDTO, loginedUserId)) {
				redirect.addAttribute("activityId", encodedId); // activityId(인코딩된 활동Id)를 파라미터로 추가시킴
				return "redirect:/activity/detail"; // 상세보기페이지로 리다이렉트
			} else 
				return "/errorPage/500page";
		}else
			return "/errorPage/500page";
	}
	
	//파일 다운로드
	@GetMapping("/activity/fileDownload")
	public void activityFileDownload(HttpServletRequest request
			,HttpServletResponse response ,String fileId) throws IOException {
		String fileName = null;
		
		ActivityFile activityFile = activityService.getActivityFile(fileId);
		File realFile = activityService.getActivityRealFile(activityFile);
		InputStream is = new FileInputStream(realFile);
		
		byte[] fileByte = is.readAllBytes();
		fileName = activityFile.getFileName();
		
		is.close();
		
		response.setContentType("application/octet-stream");
        response.setContentLength(fileByte.length);
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName,"UTF-8")+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.getOutputStream().write(fileByte);
          
        response.getOutputStream().flush();
        response.getOutputStream().close();
		
	}
	

	//파일 삭제
	@GetMapping("/activity/fileDelete")
	public String activityFileDelete(HttpServletRequest request
			, String fileId, String activityId, RedirectAttributes redirect) throws UnsupportedEncodingException {
		String loginedUserId = getLoginedUserId(request);
		
		if(!activityService.deleteActivityFile(loginedUserId, fileId)) {
			return "/errorPage/500page";
		}
		
		
		redirect.addAttribute("activityId", activityId);
		return "redirect:/activity/modify";
	}
	

}
