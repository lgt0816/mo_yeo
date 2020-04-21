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
	
	@Inject
	private JavaMailSender mailSender;
	
	@Override
	public void sendAuthorizationMail(String email, String key) 
			throws MessagingException, UnsupportedEncodingException{
		
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
	public boolean checkAuthorizationCode(String inputKey, String sessionKey) throws Exception {
		boolean result = sessionKey.equals(inputKey);
		
		return result;
	}
	

}
