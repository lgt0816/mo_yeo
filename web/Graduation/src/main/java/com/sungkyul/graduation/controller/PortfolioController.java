package com.sungkyul.graduation.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sungkyul.graduation.domain.Portfolio;
import com.sungkyul.graduation.service.PortfolioService;

@Controller
public class PortfolioController 
	extends com.sungkyul.graduation.controller.Controller{
	
	@Inject private PortfolioService portfolioService;
	
	@GetMapping(value="/portfolio")
	public String portforlios(HttpServletRequest request, Model model) {
		String loginedUserId = getLoginedUserId(request);
		
		List<Portfolio> portfolios = 
				portfolioService.getPortfolios(loginedUserId);
		
		model.addAttribute("portfolios", portfolios);
		
		return null;
	}
}
