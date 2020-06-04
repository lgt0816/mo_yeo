package com.sungkyul.graduation.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sungkyul.graduation.domain.Activity;
import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.dto.ActivityModifyFormDTO;
import com.sungkyul.graduation.service.ActivityService;
import com.sungkyul.graduation.staticNamesInterface.SessionNames;
import com.sungkyul.graduation.util.Aes256;

@Controller
public class ActivityController 
extends com.sungkyul.graduation.controller.Controller implements SessionNames{
	
	public static final String ACTIVITY_TYPE_STUDY = "스터디";
	public static final String ACTIVITY_TYPE_INTERNATIONAL = "대외활동";
	public static final String ACTIVITY_TYPE_GRADUATION = "졸업작품";
	public static final String ACTIVITY_TYPE_PROJECT = "프로젝트";
	
	private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);
	@Inject private ActivityService activityService;
	@Inject private FileController fileController;
	
	//스터디 리스트 보기 
	@GetMapping("/activity/completedStudys")
	public String completedStudyList(HttpServletRequest request, Model model) {
		String loginedUserId = getLoginedUserId(request);
		logger.info("loginedUserId {}", loginedUserId);
		
		//key : 활동완료시점의 사용자 학년 , value : 해당학년의 완료된 활동 리스트
		Map<Integer, List<CompletedActivity>> activitys 
			= activityService.getActivitys(loginedUserId, ACTIVITY_TYPE_STUDY);
		
		model.addAttribute("map", activitys);	
		
		return "completedActivitys";
	}
	
	//활동 상세 보기 (파일 추가 안되있음)
	@GetMapping("/activity/detail")
	public String completedStudyItem(@RequestParam("activityId") String activityId, 
			HttpServletRequest request, Model model) {
		logger.info("받은 파라미터값 {}", activityId);
		String loginedUserId = getLoginedUserId(request);
		
		Activity activity = 
				activityService.getActivity(loginedUserId, activityId);
		logger.info("activity {}", activity.toString());
		
		model.addAttribute("activity",activity);
		
		return "activityDetail";
	}
	
	//스터디 수정하기 화면 (파일 추가 안되있음)
	@GetMapping("/activity/modify")
	public String modifyStudyItemGet(@RequestParam("activityId") String activityId,
			HttpServletRequest request, Model model) {
		String loginedUserId = getLoginedUserId(request);
		Activity activity = 
				activityService.getActivity(loginedUserId, activityId);
		
		model.addAttribute("activity",activity);
		
		return "activityModify";
	}
	
	//스터디 수정하기 비지니스 로직
	@PostMapping("/activity/modifyPost")
	public String modifyStudyItemPost(HttpServletRequest request, 
			@ModelAttribute(name = "actModifyDTO") 
			ActivityModifyFormDTO activityModifyFormDTO,
			RedirectAttributes redirect) throws UnsupportedEncodingException{
		String loginedUserId = getLoginedUserId(request);
		String urlEncodedId = activityModifyFormDTO.getEncodedId();
		String encodedId = URLDecoder.decode(urlEncodedId, "UTF-8");
		
		//파일관련 로직 추가해야됨
		if(activityService.updateActivityResult(activityModifyFormDTO, loginedUserId)) {
			redirect.addAttribute("activityId", encodedId);	//activityId(인코딩된 활동Id)를 파라미터로 추가시킴
			return "redirect:/activity/detail";	//상세보기페이지로 리다이렉트
		}else {
			//될런지는 모름
			return "/errorPage/500page";
		}
		
	}
	
	

}
