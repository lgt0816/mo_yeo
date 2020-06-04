package com.sungkyul.graduation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.staticNamesInterface.SessionNames;

public class Controller implements SessionNames{

	public User getLoginedUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User loginedUser = (User) session.getAttribute(SESSION_LOGINED_USER);
		
		return loginedUser;
	}
	
	public String getLoginedUserId(HttpServletRequest request) {
		String loginedUserId = getLoginedUser(request).getUserId();
		return loginedUserId;
	}
}
