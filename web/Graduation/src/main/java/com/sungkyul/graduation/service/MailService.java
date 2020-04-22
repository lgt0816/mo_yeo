package com.sungkyul.graduation.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

public interface MailService {	
	public void sendFindPasswordMail();		//비밀번호 찾기 메일 보내기
	void sendAuthorizationMail(String email, String key) throws MessagingException, UnsupportedEncodingException; //회원가입 인증메일 보내기
	boolean checkAuthorizationCode(String inputKey, String sessionKey) throws Exception;//회원가입 인증번호 확인
	public void sendTempPwMail(String email, String tempPw) throws MessagingException, UnsupportedEncodingException;
	
}
