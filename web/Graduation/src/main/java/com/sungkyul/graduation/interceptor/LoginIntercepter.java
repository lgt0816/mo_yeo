package com.sungkyul.graduation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sungkyul.graduation.staticNamesInterface.SessionNames;

public class LoginIntercepter extends HandlerInterceptorAdapter implements SessionNames{

	//세션이 있는경우 세션을 날려줌
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(SESSION_LOGINED_USER)!=null) {
			session.removeAttribute(SESSION_LOGINED_USER);
		}
		
		return true;
	}

	//세션에 로그인된 유저를 추가해줌
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		//컨트롤에서 받아옴
		Object user = modelAndView.getModelMap().get("user");
		if(user !=null) {
			session.setAttribute(SESSION_LOGINED_USER, user);
		}
		
	}
	

}
