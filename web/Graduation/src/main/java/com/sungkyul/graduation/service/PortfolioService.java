package com.sungkyul.graduation.service;

import java.util.List;

import com.sungkyul.graduation.domain.Portfolio;

public interface PortfolioService {

	List<Portfolio> getPortfolios(String loginedUserId);

}
