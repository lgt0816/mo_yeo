package com.sungkyul.graduation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.domain.Portfolio;
import com.sungkyul.graduation.persistence.PortfolioDAO;

@Service
public class PortfolioServiceImpl implements PortfolioService{

	@Inject private PortfolioDAO portfolioDAO;
	
	//포트폴리오들을 반환(포트폴리오에 연결되있는 활동들 포함)
	@Override
	public List<Portfolio> getPortfolios(String loginedUserId) {
		
		List<Portfolio> result =
				portfolioDAO.selectPortfolios(loginedUserId);
		for(int i=0; i<result.size();i++) {
			String portfolioId = Integer.toString(result.get(i).getPortfolioId()); 
			List<CompletedActivity> activitys = 
					portfolioDAO.selectIncludedACT(portfolioId);
			result.get(i).setActivitys((ArrayList<CompletedActivity>) activitys);
		}
		
		return result;
	}
	
	
	//포트폴리오 타이틀 수정(오버라이딩 안했음 - 파라미터 정해지면 수정해서 오버라이딩 실시)
	public boolean modifyPortfolioTitle(String userId, String portfolioId, String portfolioTitle) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("portfolioId", portfolioId);
		paramMap.put("userId", userId);
		paramMap.put("portfolioTitle", portfolioTitle);
		
		return portfolioDAO.updataPortfolioTitle(paramMap);
	}

}
