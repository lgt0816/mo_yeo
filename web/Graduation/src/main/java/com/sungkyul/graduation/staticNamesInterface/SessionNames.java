package com.sungkyul.graduation.staticNamesInterface;

public interface SessionNames {
//	final static String LOGIN = "loginUser";
	static final String SESSION_ID_CHECK = "userId_Checked"; // 세션에 아이디 중복확인 받았는지 저장하여 체크하는 용도
	static final String SESSION_AUTHORIZATION_CODE = "authorizationCode"; // 세션 key 메일인증번호
	static final String SESSION_AUTHORIZATION_CLEAR = "authorizationClear"; // 세션key 메일인증 완려
	static final String SESSION_LOGINED_USER = "loginedUser";

}
