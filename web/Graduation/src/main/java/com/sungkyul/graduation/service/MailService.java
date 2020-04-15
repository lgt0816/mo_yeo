package com.sungkyul.graduation.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

public interface MailService {
	public void sendAuthorizationMail(String email, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException;	//회원가입 인증메일 보내기
	public void sendFindPasswordMail();		//비밀번호 찾기 메일 보내기
	public boolean checkAuthorizationCode(String key, HttpServletRequest request) throws Exception;//회원가입 인증번호 확인
}
