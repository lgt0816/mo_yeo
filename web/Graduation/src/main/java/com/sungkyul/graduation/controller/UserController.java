package com.sungkyul.graduation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;
import com.sungkyul.graduation.service.MailService;
import com.sungkyul.graduation.service.UserService;


@Controller
public class UserController {
	 
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SESSION_ID_CHECK = "userId_Checked";	//세션에 아이디 중복확인 받았는지 저장하여 체크하는 용도
	
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
	@GetMapping(value = "/join/checkUserId")
	@ResponseBody
	public Map<String, Object> checkUserId(@RequestParam("userId")String userId, HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		if(userService.checkUserId(userId)) {
			session.setAttribute(SESSION_ID_CHECK, true);
			result.put("result", "사용가능한 아이디 입니다.");
		}else {
			session.setAttribute(SESSION_ID_CHECK, false);
			result.put("result", "중복된 아이디 입니다.");
		}
		
		System.out.println(session.getAttribute(SESSION_ID_CHECK));
		return result;
	}
	
	//인증메일 보내기
	@GetMapping(value = "/join/authorizationMail")
	@ResponseBody
	public Map<String, Object> authorizationMail(@RequestParam("email") String email, HttpServletRequest request ) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(userService.checkEmail(email)) {
			mailService.sendAuthorizationMail(email, request);
			result.put("result", "입력된 이메일로 인증번호를 보냈습니다.");
		}else 
			result.put("result", "이미 사용중인 이메일주소 입니다.");
		
		return result;
	}
	
	//인증코드 체크
	@GetMapping(value = "/join/authorizationCheck")
	@ResponseBody
	public Map<String, Object> authorizationCheck(@RequestParam("authorizationCode") String key, HttpServletRequest request ) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(mailService.checkAuthorizationCode(key, request)) 
			result.put("result", "인증에 성공하였습니다.");
		else 
			result.put("result", "올바르지 않은 인증코드 입니다.");
		
		
		
		return result;
	}
	
	
	

}
