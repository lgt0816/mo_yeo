package com.sungkyul.graduation.staticNamesInterface;

public interface AjaxNames {
	static final String AJAX_RESULT = "result";
	static final String AJAX_FLAG = "flag";
	static final boolean AJAX_RESULT_FAIL = false; // 이메일 중복확인 성공
	static final boolean AJAX_RESULT_CLEAR = true; // 이메일 중복확인 실패(중복된 이메일인 경우)
	static final String AJAX_AUTHORIZATAON_CHECK_CLEAR = "authorizationClear"; // 메일인증 성공
	static final String AJAX_AUTHORIZATAON_CHECK_FAILE = "authorizationFaile"; // 메일인증 실패
	static final String AJAX_USERID_CHECK_CLEAR = "userIdCheckClear"; // 아이디 중복확인 성공
	static final String AJAX_USERID_CHECK_FAILE = "userIdCheckFaile"; // 아이디 중복확인 실패(중복된 아이디인 경우)
}
