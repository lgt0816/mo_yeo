package com.sungkyul.graduation.service;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sungkyul.graduation.util.MailHandler;
import com.sungkyul.graduation.util.TempKey;

@Service
public class MailServiceImpl implements MailService{

	private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	private static final String SESSION_AUTHORIZATION_CODE="authorizationCode";
	private static final String SESSION_AUTHORIZATION_CLEAR="authorizationClear";
	
	@Inject
	private JavaMailSender mailSender;
	
	@Override
	public void sendAuthorizationMail(String email, HttpServletRequest request) 
			throws MessagingException, UnsupportedEncodingException{
		String key = new TempKey().getKey(8, false);
		HttpSession session = request.getSession();
		session.setAttribute(SESSION_AUTHORIZATION_CODE, key);
		
		MailHandler mailHandler = new MailHandler(mailSender);
		mailHandler.setSubject("[회원가입 인증]");	//메일 제목
		mailHandler.setText(new StringBuffer()	//메일 내용
				.append("<h1>회원가입 인증</h1>")
				.append("<p>당신의 회원가입 인증 코드입니다.</p>")
				.append("<p>"+key+"</p>")
				.toString());
		mailHandler.setFrom("lgt0816@gmail.com", "모여라여기 회원가입");
		mailHandler.setTo(email);
		mailHandler.send();
		
		logger.info("Send Authorization Mail!!!");
	}

	@Override
	public void sendFindPasswordMail() {
		// TODO Auto-generated method stub
		
	}

	//회원가입 인증키 확인
	@Override
	public boolean checkAuthorizationCode(String key, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String sessionKey = (String) session.getAttribute(SESSION_AUTHORIZATION_CODE);
		if(sessionKey.equals(key)) {
			session.setAttribute(SESSION_AUTHORIZATION_CLEAR, true);
			return true;
		}else
			return false;
	}
	

}
