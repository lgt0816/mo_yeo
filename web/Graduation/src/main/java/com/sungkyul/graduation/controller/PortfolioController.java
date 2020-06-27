package com.sungkyul.graduation.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.domain.Portfolio;
import com.sungkyul.graduation.service.ActivityService;
import com.sungkyul.graduation.service.PortfolioService;

@Controller
public class PortfolioController 
	extends com.sungkyul.graduation.controller.Controller{
	
	@Inject private PortfolioService portfolioService;
	@Inject private ActivityService activityService;
	private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);
	//포트폴리오 페이지
	@GetMapping(value="/portfolio")
	public String portfolios(HttpServletRequest request, Model model) {
		String loginedUserId = getLoginedUserId(request);
		
		List<Portfolio> portfolios = 
				portfolioService.getPortfolios(loginedUserId);
		
		model.addAttribute("portfolios", portfolios);
		
		return "portfolioList";
	}
	
	//포트폴리오 생성하기 페이지
	@GetMapping(value = "/portfolio/create")
	public String createPortfolio(HttpServletRequest request, Model model) {
		String loginedUserId = getLoginedUserId(request);
		List<CompletedActivity> activitys = 
				activityService.getAllActivity(loginedUserId);
		model.addAttribute("activitys", activitys);
		
		return "portfolioCreate";
	}
	
	//포트폴리오 생성하기 페이지 비지니스로직
	@PostMapping(value = "/portfolio/createPost")
	public String createPortfolioPost(String portfolioTitle,
			@RequestParam(required = false) String[] activityIds,
			HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		String loginedUserId = getLoginedUserId(request);
		
		if(activityIds==null) {
			//성공하면 포트폴리오 페이지로 실패하면 에러패이지로
			return portfolioService.createPortfolio(loginedUserId, portfolioTitle) ?
					"redirect:/portfolio" : "/errorPage/500page";
		}else {
			
			return portfolioService.createPortfolio(loginedUserId, portfolioTitle, activityIds) ?
					"redirect:/portfolio" : "/errorPage/500page";
		}
		
	}
	
	//포트폴리오 수정하기 페이지
	@GetMapping(value="/portfolio/modify")
	public String modifyPortfolio(HttpServletRequest request,
			String portfolioId, Model model) {
		String loginedUserId = getLoginedUserId(request);
		String encodedPortfolioId = portfolioId;
		
		List<CompletedActivity> allActivitys = 
				activityService.getAllActivity(loginedUserId);
		Portfolio portfolio = 
				portfolioService.getPortfolio(loginedUserId, encodedPortfolioId);
		
		model.addAttribute("allActivitys", allActivitys);
		model.addAttribute("portfolio", portfolio);
		
		return "portfolioModify";
	}
	
	//포트폴리오 수정하기 페이지 비지니스로직
	@PostMapping(value="/portfolio/modifyPost")
	public String modifyPortfolioPost(String portfolioId,
			String portfolioTitle,
			@RequestParam(required = false) String[] activityIds,
			HttpServletRequest request) {
		String loginedUserId = getLoginedUserId(request);

		logger.info("ppId : {}",portfolioId);
		logger.info("ppTitle : {}",portfolioTitle);
		if(activityIds!=null) {
			for(int i=0;i<activityIds.length;i++) {
				logger.info("actIds : {}",activityIds[i].toString());
			}
		}else {
			System.out.println("activityIds is null!!!");
		}
		
		
		System.out.println(portfolioService.modifyPortfolioTitle(loginedUserId, portfolioId, portfolioTitle));
		
		
		if(activityIds==null) {
			portfolioService.modifyIncludedActivity(loginedUserId, portfolioId);
		}else {
			portfolioService.modifyIncludedActivity(loginedUserId, portfolioId,activityIds);
		}
		
		return "redirect:/portfolio";
	}
	
	
	//포트폴리오 삭제하기
	@GetMapping(value = "/portfolio/delete")
	public String deletePortfolio(String portfolioId,
			HttpServletRequest request) {
		String loginedUserId = getLoginedUserId(request);
		String encodedId = portfolioId;
		
		logger.info("encodedId {}", encodedId);
		
		return (portfolioService.deletePortfolio(loginedUserId, encodedId))?
				"redirect:/portfolio" : "/errorPage/500page";
		
	}
	
}
