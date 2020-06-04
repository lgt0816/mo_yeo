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
	private static final String INSERT_PORTFOLIO = NS+".insertPortfolio";
	private static final String SELECT_INCLUDED_ACTICITY= NS+".selectIncludedActivity";
	private static final String UPDATE_PORTFOLIO_TITLE= NS+".updatePortfolioTitle";
	
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
	
	@Override
	public boolean updataPortfolioTitle(Map<String, Object> paramMap) {
		
		return (session.update(UPDATE_PORTFOLIO_TITLE, paramMap)==0)? false : true;
	}

}
