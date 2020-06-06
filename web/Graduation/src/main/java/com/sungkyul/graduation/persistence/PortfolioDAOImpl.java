package com.sungkyul.graduation.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.domain.Portfolio;

@Repository
public class PortfolioDAOImpl implements PortfolioDAO {

	@Inject private SqlSession session;
	
	private static final String NS = "com.sungkyul.graduation.persistence.PortfolioMapper";
	private static final String SELECT_PORTFOLIOS = NS+".selectPortfolios";
	private static final String SELECT_INCLUDED_ACTICITY= NS+".selectIncludedActivity";
	private static final String UPDATE_PORTFOLIO_TITLE= NS+".updatePortfolioTitle";
	private static final String DELETE_ALL_INCLUDED_ACTIVITY =NS+".deleteAllIncludedActivty";
	private static final String DELETE_PORTFOLIO =NS+".deletePortfolio";
	private static final String INSERT_PORTFOLIO = NS+".insertPortfolio";
	private static final String INSERT_INCLUDED_ACTIVITY =NS+".insertIncludedActivity";
	private static final String SELECT_CURRNT_PORTFOLIO_ID = NS+".selectCurrentPortfolioId";
	private static final String SELECT_PORTFOLIO = NS+".selectPortfolio";
	
	
	
	@Override
	public List<Portfolio> selectPortfolios(String userId) {
		List<Portfolio> result = session.selectList(SELECT_PORTFOLIOS, userId);
		
		return result;
	}
	
	@Override
	public List<CompletedActivity> selectIncludedACT(String portfolioId){
		List<CompletedActivity> result = 
				session.selectList(SELECT_INCLUDED_ACTICITY, portfolioId);
		
		return result;
	}
	
	
	//paramMap : userId, portfolioId, portfolioTitle
	@Override
	public boolean updataPortfolioTitle(Map<String, Object> paramMap) {
		
		return (session.update(UPDATE_PORTFOLIO_TITLE, paramMap)==0)? false : true;
	}
	
	//paramMap : userId, portfolioId
	@Override
	public boolean deleteAllIncludedACT(Map<String, Object> paramMap) {
		
		return (session.delete(DELETE_ALL_INCLUDED_ACTIVITY, paramMap)==0)? false:true;
	}
	
	//paramMap : uesrId, portfolioId
	@Override
	public boolean deletePortfolio(Map<String, Object> paramMap) {
		
		return (session.delete(DELETE_PORTFOLIO, paramMap)==0)? false:true;
	}
	
	
	//paramMap : userId, portfolioTitle
	@Override
	public boolean insertPortfolio(Map<String, Object> paramMap) {
		
		return (session.insert(INSERT_PORTFOLIO, paramMap)==0)? false:true;
	}
	
	//paramMap : userId, portfolioId, activityId
	@Override
	public boolean insertIncludedACT(Map<String, Object> paramMap) {
		
		return (session.insert(INSERT_INCLUDED_ACTIVITY, paramMap)==0)? false:true;
	}

	@Override
	public String selectCurrentPortfolioId(String userId) {
		String result = 
				session.selectOne(SELECT_CURRNT_PORTFOLIO_ID, userId);
		
		return result;
	}
	
	//paramMap : userId, portfolioId
	@Override
	public Portfolio selectPortfolio(Map<String, Object> paramMap) {
		Portfolio result = session.selectOne(SELECT_PORTFOLIO, paramMap);
		
		return result;
	}

}
