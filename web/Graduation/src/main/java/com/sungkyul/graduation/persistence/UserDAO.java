package com.sungkyul.graduation.persistence;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.FindUserIdDTO;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;
import com.sungkyul.graduation.dto.UserUpdateDTO;

public interface UserDAO {

	User login(LoginDTO dto) throws Exception;

	boolean join(JoinDTO dto) throws Exception;
	
	boolean checkEmail(String email) throws Exception;

	boolean checkUserId(String userId) throws Exception;

	User updateUserPw(UserUpdateDTO userUpdateDTO);	//변경할 예정

	User updateUser(UserUpdateDTO userUpdateDTO);

	String findUserId(FindUserIdDTO findIdDTO);

	boolean updateUserPw(String userId, String newPw);

}
