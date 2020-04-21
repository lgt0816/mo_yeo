package com.sungkyul.graduation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;
import com.sungkyul.graduation.service.MailService;
import com.sungkyul.graduation.service.UserService;
import com.sungkyul.graduation.util.TempKey;


@Controller
public class UserController {
	 
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SESSION_ID_CHECK = "userId_Checked";	//세션에 아이디 중복확인 받았는지 저장하여 체크하는 용도
	private static final String SESSION_AUTHORIZATION_CODE="authorizationCode";
	private static final String SESSION_AUTHORIZATION_CLEAR="authorizationClear";
	private static final String AJAX_RESULT="result";
	private static final String AJAX_FLAG="flag";
	private static final boolean AJAX_RESULT_FAIL=false;
	private static final boolean AJAX_RESULT_CLEAR=true;
	
	@Inject
	private UserService userService;
	@Inject
	private MailService mailService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void login() throws Exception{
		logger.info("login GET....");
		
	}
	
	@RequestMapping(value="/loginPost", method = RequestMethod.POST)
	public void loginPost(LoginDTO dto, Model model) throws Exception{
		logger.info("loginPost={}", dto);
		
		try {
			User user = userService.login(dto);
			logger.info("user={}",user);
			if(user != null) {
				//로그인 성공시
				model.addAttribute("user", user);
			}else {
				//로그인 실패시
				model.addAttribute("loginResult", "Login Fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void join() {
		logger.info("join GET....");
		
	}
	
	@RequestMapping(value = "/joinPost", method = RequestMethod.POST)
	public void joinPost(JoinDTO dto, Model model) {
		logger.info("joinPost={}", dto);
		
		try {
			if(userService.join(dto)) {
				model.addAttribute("joinResult", "join Complite");
			}else {
				model.addAttribute("joinResult", "join Fail");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//회원 중복체크
	@PostMapping(value = "/join/checkUserId")
	@ResponseBody
	public Map<String, Object> checkUserId(@RequestBody Map<String,String> requestParam, HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();	//결과 메시지
		HttpSession session = request.getSession();	//아이디 중복확인결과를 세션에 저장한다.
		String userId = requestParam.get("userId");	//파라미터로 받아온 userId값
		
		if(userId.equals("")) {
			result.put(AJAX_RESULT, "아이디를 입력해주세요.");
		}
		else if(userService.checkUserId(userId)) {
			session.setAttribute(SESSION_ID_CHECK, true);
			result.put(AJAX_RESULT, "사용가능한 아이디 입니다.");
		}else {
			session.setAttribute(SESSION_ID_CHECK, false);
			result.put(AJAX_RESULT, "중복된 아이디 입니다.");
		}
		
		System.out.println(session.getAttribute(SESSION_ID_CHECK));
		return result;
	}
	
	//메일 중복확인
	@PostMapping(value = "/join/authorizationMailCheck")
	@ResponseBody
	public Map<String, Object> authorizationMailCheck(@RequestBody Map<String,String> requestParams,
			HttpServletRequest request ) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String email1 = requestParams.get("email1");
		String email2 = requestParams.get("email2");
		String email = email1+"@"+email2;
		
		if(userService.checkEmail(email)) {
//			mailService.sendAuthorizationMail(email, request);
			result.put(AJAX_RESULT, "입력된 이메일로 인증번호를 보냈습니다.");
			result.put(AJAX_FLAG, AJAX_RESULT_CLEAR);
		}else { 
			result.put(AJAX_RESULT, "이미 사용중인 이메일주소 입니다.");
			result.put(AJAX_FLAG, AJAX_RESULT_FAIL);
		}
		
		return result;
	}
	
	//인증메일 보내기
	@PostMapping(value = "/join/authorizationMailSend")
	@ResponseBody
	public Map<String, Object> authorizationMailSend(@RequestBody Map<String,String> requestParams,
			HttpServletRequest request ) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();	//결과값을 보내기위한 해쉬맵 생성
		String key = new TempKey().getKey(8, false);	//인증번호 생성
		String email1 = requestParams.get("email1");
		String email2 = requestParams.get("email2");
		String email = email1+"@"+email2;	//이메일주소 완성
		
		HttpSession session = request.getSession();
		session.setAttribute(SESSION_AUTHORIZATION_CODE, key);	//세션에 인증번호 저장
		
		mailService.sendAuthorizationMail(email, key);
		
		return result;
	}
	
	//인증코드 체크
	@PostMapping(value = "/join/authorizationCheck")
	@ResponseBody
	public Map<String, Object> authorizationCheck(@RequestBody Map<String,String> requestParams, HttpServletRequest request ) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String sessionKey = (String) session.getAttribute(SESSION_AUTHORIZATION_CODE);
		String inputKey = requestParams.get("inputKey");
		
		if(mailService.checkAuthorizationCode(inputKey, sessionKey)) { 
			session.setAttribute(SESSION_AUTHORIZATION_CLEAR, true);
			result.put("result", "인증에 성공하였습니다.");
		}
		else {
			session.setAttribute(SESSION_AUTHORIZATION_CLEAR, false);
			result.put("result", "올바르지 않은 인증코드 입니다.");
		}
		
		return result;
	}
	
	
	

}
