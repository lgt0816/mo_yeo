package com.sungkyul.graduation.service;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.FindUserIdDTO;
import com.sungkyul.graduation.dto.FindUserPwDTO;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;
import com.sungkyul.graduation.dto.UserUpdateDTO;

public interface UserService {

	User login(LoginDTO dto) throws Exception;

	boolean join(JoinDTO dto) throws Exception;
	
	boolean checkEmail(String email) throws Exception;
	boolean checkUserId(String userId) throws Exception;

	User updateUserPw(UserUpdateDTO userUpdateDTO);	//변경 예정

	User updateUser(UserUpdateDTO userUpdateDTO);

	String findUserId(FindUserIdDTO findIdDTO);

	boolean checkExistUser(FindUserPwDTO findPwDTO);

	boolean updateUserPw(String userId, String userPw, String newPw);
	
	

}
