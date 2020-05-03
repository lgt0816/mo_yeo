package com.sungkyul.graduation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sungkyul.graduation.domain.Student;
import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.FindUserIdDTO;
import com.sungkyul.graduation.dto.FindUserPwDTO;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;
import com.sungkyul.graduation.dto.UserUpdateDTO;
import com.sungkyul.graduation.dto.UserUpdatePwDTO;
import com.sungkyul.graduation.service.MailService;
import com.sungkyul.graduation.service.UserService;
import com.sungkyul.graduation.staticNamesInterface.AjaxNames;
import com.sungkyul.graduation.staticNamesInterface.SessionNames;
import com.sungkyul.graduation.util.TempKey;

@Controller
public class UserController implements SessionNames, AjaxNames{

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String MODEL_USER= "user";
	private static final String MODEL_PAGE_SUBTITLE="pageSubtitle";
	private static final String MODEL_FIND_USER_RESULT="findUserResult";
	private static final String MODEL_LOGIN_RESULT = "loginResult";
	
	@Inject private UserService userService;
	@Inject private MailService mailService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(Model model, 
			@RequestParam(required=false)String loginResult) throws Exception {
		logger.info("login GET....");
		
		if(loginResult != null) {
			model.addAttribute(MODEL_LOGIN_RESULT, loginResult);
		}
	}
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public String loginPost(LoginDTO dto, Model model, HttpServletRequest requset, 
			RedirectAttributes redirect) throws Exception {
		logger.info("loginPost={}", dto);
		HttpSession session = requset.getSession();
		

		User user = userService.login(dto);
		logger.info("user={}", user);
		if (user != null) {
			// 로그인 성공시
			session.setAttribute(SESSION_LOGINED_USER, user);
			return "redirect:/";
		} else {
			// 로그인 실패시
			redirect.addAttribute(MODEL_LOGIN_RESULT, "Login Fail!!");
			return "redirect:/login";
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
			if (userService.join(dto)) {
				model.addAttribute("userName", dto.getName());
			} else {
				model.addAttribute("joinResult", "join Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();// 세션 초기화

		return "redirect:/login";
	}
	
	//로그인된 유저 정보조회
	@GetMapping(value = "/userInfo")
	public String userInfo(Model model, HttpServletRequest request) {
		logger.info("Get userInfo...");
		HttpSession session = request.getSession();
		
		User user = (Student) session.getAttribute(SESSION_LOGINED_USER);
		model.addAttribute("user", user);

		return "userInfo";
	}
	
	//정보수정, 비밀번호 변경	<-- 로직을 바꿔야됨 특히 updateuserPw
	@PostMapping(value = "/userUpdate.do")
	public String userUpdate(@ModelAttribute UserUpdateDTO userUpdateDTO, HttpServletRequest request) throws Exception{
		logger.info("Post userUpdate & userUpdateDTO{}",userUpdateDTO);
		
		HttpSession session = request.getSession();
		User sessionUser = (Student) session.getAttribute(SESSION_LOGINED_USER);
		String sessionUserPw = sessionUser.getUserPw();	//세션에 저장되있는 유저정보의 비밀번호
		String userPw = userUpdateDTO.getUserPw1();		//유저가 입력한 원래 비밀번호
		String updateUserPw = userUpdateDTO.getUserPw3();	//변경하고 자하는 비밀번호
		userUpdateDTO.setUserId(sessionUser.getUserId());	// 아이디를 세션에서 받아서 넘겨줌
		
		//비밀번호 확인(암호화 추가해 주어야 함)
		if(sessionUserPw.equals(userPw) && !updateUserPw.equals("")) {
			//비밀번호 변경 + 개인정보 변경
			User user = userService.updateUserPw(userUpdateDTO);
			if(user !=null)	//null 인경우는 실패 
				session.setAttribute(SESSION_LOGINED_USER, user);
				
		}else if(sessionUserPw.equals(userPw) && updateUserPw.equals("")) {
			//개인정보 변경만
			User user = userService.updateUser(userUpdateDTO);
			if(user !=null)	//null인 경우는 실패
				session.setAttribute(SESSION_LOGINED_USER, user);
		}
		
		return "redirect:/userInfo";
	}
	
	//비밀번호 변경
	@PostMapping(value = "userUpdatePw.do")
	public String userUpdatePw(@ModelAttribute UserUpdatePwDTO userPwDTO,  
			HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		User loginedUser = (User) session.getAttribute(SESSION_LOGINED_USER);
		String userId = loginedUser.getUserId();
		String newPw = userPwDTO.getNewPw();
		
		//비밀번호1과 비밀번호2가 일치하지 않거나 저장된 비밀번호화 일치하지 않으면 userInfo페이지로 redirect시킴
		if(!userPwDTO.getUserPw1().equals(userPwDTO.getUserPw2()) || 
				!userPwDTO.getUserPw1().equals(loginedUser.getUserPw())) {
			return "redirect:/userInfo";
		}
		
		//비밀번호 변경 실행
		if(userService.updateUserPw(userId, newPw)) {
			//비밀번호 변경 성공시 session에 새로운 user정보를 저장
			LoginDTO tempLoginDTO = new LoginDTO(userId, newPw);
			User user= userService.login(tempLoginDTO);
			session.setAttribute(SESSION_LOGINED_USER, user);
		}
		
		return "redirect:/userInfo";
	}
	
	// 아이디/비밀번호 찾기 페이지
	@GetMapping(value = "/findUser")
	public String findUser() {
		logger.info("Get findUser.....");
		return "findUser";
	}
	
	//아이디 찾기
	@PostMapping(value = "/findUserId")
	public String findUserId(FindUserIdDTO findIdDTO, Model model) {
		logger.info("POST findUserId & findIdDTO{}", findIdDTO);
		String userId = userService.findUserId(findIdDTO);
		if(userId != null) {
			//userId를 찾은경우
			model.addAttribute(MODEL_PAGE_SUBTITLE, "아이디 찾기");
			model.addAttribute(MODEL_FIND_USER_RESULT, "당신의 아이디는 "+userId +"입니다.");
		}else {
			//해당 결과값이 없는경우
			model.addAttribute(MODEL_PAGE_SUBTITLE, "아이디 찾기");
			model.addAttribute(MODEL_FIND_USER_RESULT, "해당 결과가 없습니다.");
			
		}
		return "forward:/findUserResult";
	}
	
	//비밀번호 찾기
	@PostMapping(value = "/findUserPw")
	public String findUserPw(FindUserPwDTO findPwDTO, Model model) throws Exception{
		if(userService.checkExistUser(findPwDTO)) {
			//아이디가 있는경우
			String tempPw = new TempKey().getKey(8, false); // 임시 비밀번호 생성
			userService.updateUserPw(findPwDTO.getUserId(), tempPw); //임시 비밀번호로 변경
			mailService.sendTempPwMail(findPwDTO.getEmail(), tempPw);	//입력한 이메일로 임시 비밀번호 전송
			System.out.println(tempPw);
			model.addAttribute(MODEL_PAGE_SUBTITLE, "비밀번호 찾기");
			model.addAttribute(MODEL_FIND_USER_RESULT, "입력하신 이메일로 임시 비밀번호를 전송했습니다.");
		}else {
			model.addAttribute(MODEL_PAGE_SUBTITLE, "비밀번호 찾기");
			model.addAttribute(MODEL_FIND_USER_RESULT, "해당 결과가 없습니다.");
		}
		return "forward:/findUserResult";
	}
	
	@PostMapping(value = "/findUserResult")
	public void findUserResult() {
		
	}
	
	//=====================================  AJAX ===========================================

	// 회원 중복체크
	@PostMapping(value = "/join/checkUserId")
	@ResponseBody
	public Map<String, Object> checkUserId(@RequestBody Map<String, String> requestParam, HttpServletRequest request)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>(); // 결과 메시지
		HttpSession session = request.getSession(); // 아이디 중복확인결과를 세션에 저장한다.
		String userId = requestParam.get("userId"); // 파라미터로 받아온 userId값

		if (userId.equals("")) {
			result.put(AJAX_RESULT, "아이디를 입력해주세요.");
		} else if (userService.checkUserId(userId)) {
			session.setAttribute(SESSION_ID_CHECK, true);
			result.put(AJAX_RESULT, "사용가능한 아이디 입니다.");
			result.put(AJAX_FLAG, AJAX_USERID_CHECK_CLEAR);
		} else {
			session.setAttribute(SESSION_ID_CHECK, false);
			result.put(AJAX_RESULT, "중복된 아이디 입니다.");
			result.put(AJAX_FLAG, AJAX_USERID_CHECK_FAILE);
		}

		System.out.println(session.getAttribute(SESSION_ID_CHECK));
		return result;
	}

	// 메일 중복확인
	@PostMapping(value = "/join/authorizationMailCheck")
	@ResponseBody
	public Map<String, Object> authorizationMailCheck(@RequestBody Map<String, String> requestParams,
			HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String email1 = requestParams.get("email1");
		String email2 = requestParams.get("email2");
		String email = email1 + "@" + email2;

		if (userService.checkEmail(email)) {
			result.put(AJAX_RESULT, "입력된 이메일로 인증번호를 보냈습니다.");
			result.put(AJAX_FLAG, AJAX_RESULT_CLEAR);
		} else {
			result.put(AJAX_RESULT, "이미 사용중인 이메일주소 입니다.");
			result.put(AJAX_FLAG, AJAX_RESULT_FAIL);
		}

		return result;
	}

	// 인증메일 보내기
	@PostMapping(value = "/join/authorizationMailSend")
	@ResponseBody
	public Map<String, Object> authorizationMailSend(@RequestBody Map<String, String> requestParams,
			HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>(); // 결과값을 보내기위한 해쉬맵 생성
		String key = new TempKey().getKey(8, false); // 인증번호 생성
		String email1 = requestParams.get("email1");
		String email2 = requestParams.get("email2");
		String email = email1 + "@" + email2; // 이메일주소 완성

		HttpSession session = request.getSession();
		session.setAttribute(SESSION_AUTHORIZATION_CODE, key); // 세션에 인증번호 저장

		mailService.sendAuthorizationMail(email, key);

		return result;
	}

	// 인증코드 체크
	@PostMapping(value = "/join/authorizationCheck")
	@ResponseBody
	public Map<String, Object> authorizationCheck(@RequestBody Map<String, String> requestParams,
			HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String sessionKey = (String) session.getAttribute(SESSION_AUTHORIZATION_CODE);
		String inputKey = requestParams.get("inputKey");

		if (mailService.checkAuthorizationCode(inputKey, sessionKey)) {
			session.setAttribute(SESSION_AUTHORIZATION_CLEAR, true);
			result.put("result", "인증에 성공하였습니다.");
			result.put(AJAX_FLAG, AJAX_AUTHORIZATAON_CHECK_CLEAR);
		} else {
			session.setAttribute(SESSION_AUTHORIZATION_CLEAR, false);
			result.put("result", "올바르지 않은 인증코드 입니다.");
			result.put(AJAX_FLAG, AJAX_AUTHORIZATAON_CHECK_FAILE);
		}

		return result;
	}

}
