package com.sungkyul.graduation.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class PortfolioDAOTest {
	
	@Inject private PortfolioDAO portfolioDAO;
	
//	@Test
//	public void testInsertPortfolio() {
//		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userId", "20130946");
//		paramMap.put("portfolioTitle", "포트폴리오 입니다");
//		
//		if(portfolioDAO.insertPortfolio(paramMap)) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
//	}
	
//	@Test
//	public void testUpdatePortfolioTitle() {
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userId", "20130946");
//		paramMap.put("portfolioTitle", "수정 입니다");
//		paramMap.put("portfolioId", "4");
//		
//		if(portfolioDAO.updataPortfolioTitle(paramMap)) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
//		
//		
//	}
	
//	@Test
//	public void testDeletePortfolio() {
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userId", "20130946");
//		paramMap.put("portfolioId", "4");
//		
//		if(portfolioDAO.deletePortfolio(paramMap)) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
//	}
	
//	@Test
//	public void testDeleteAllIncludedACT() {
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userId", "20130946");
//		paramMap.put("portfolioId", "2");
//		
//		if(portfolioDAO.deleteAllIncludedACT(paramMap)) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
//	}
	
//	@Test
//	public void testInsertIncludedACT() {
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userId", "20130946");
//		paramMap.put("portfolioId", "2");
//		paramMap.put("activityId", "1");
//		
//		if(portfolioDAO.insertIncludedACT(paramMap)) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
//	}
	

}
