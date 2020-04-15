package com.sungkyul.graduation.service;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;

public interface UserService {

	User login(LoginDTO dto) throws Exception;

	boolean join(JoinDTO dto) throws Exception;
	
	boolean checkEmail(String email) throws Exception;
	boolean checkUserId(String userId) throws Exception;
	

}
