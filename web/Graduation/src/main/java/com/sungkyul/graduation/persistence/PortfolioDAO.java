package com.sungkyul.graduation.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.domain.Portfolio;

public interface PortfolioDAO {

	List<Portfolio> selectPortfolios(String loginedUserId);

	List<CompletedActivity> selectIncludedACT(String portfolioId);

	boolean updataPortfolioTitle(Map<String, Object> paramMap);

}
