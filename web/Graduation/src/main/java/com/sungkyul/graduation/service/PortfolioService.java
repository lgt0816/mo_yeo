package com.sungkyul.graduation.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.sungkyul.graduation.domain.Portfolio;

public interface PortfolioService {

	List<Portfolio> getPortfolios(String loginedUserId);

	boolean createPortfolio(String userId, String portfolioTitle);

	boolean createPortfolio(String userId, String portfolioTitle, String[] activityIds)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException;

	boolean deletePortfolio(String loginedUserId, String encodedId);

	Portfolio getPortfolio(String userId, String encodedId);

	boolean modifyPortfolioTitle(String userId, String urlEncodedId, String portfolioTitle);

	boolean modifyIncludedActivity(String userId, String urlEncodedId, String[] encodedACTIds);

	boolean modifyIncludedActivity(String userId, String urlEncodedId);

}
