package com.sungkyul.graduation.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.FindUserIdDTO;
import com.sungkyul.graduation.dto.FindUserPwDTO;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;
import com.sungkyul.graduation.dto.UserUpdateDTO;
import com.sungkyul.graduation.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDAO dao;

	@Override
	public User login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public boolean join(JoinDTO dto) throws Exception{
		return dao.join(dto);
		
	}
	
	@Override
	public boolean checkEmail(String email) throws Exception{
		return dao.checkEmail(email);
	}

	@Override
	public boolean checkUserId(String userId) throws Exception {
		return dao.checkUserId(userId);
	}

	//비밀번호 + 개인정보 변경		<-- 변경할 예정(삭제예정)
	@Override
	public User updateUserPw(UserUpdateDTO userUpdateDTO) {
		return dao.updateUserPw(userUpdateDTO);
	}

	//개인정보만 변경
	@Override
	public User updateUser(UserUpdateDTO userUpdateDTO) {
		return dao.updateUser(userUpdateDTO);
	}

	//아이디 찾기
	@Override
	public String findUserId(FindUserIdDTO findIdDTO) {
		return dao.findUserId(findIdDTO);
	}

	//비밀번호 찾기(해당 유저가 있는지 확인)
	@Override
	public boolean checkExistUser(FindUserPwDTO findPwDTO) {
		String userId = dao.findUserId(findPwDTO);
		
		if(userId!=null && userId.equals(findPwDTO.getUserId())) {
			return true;
		}
		
		return false;
	}

	//비밀번호 변경
	@Override
	public boolean updateUserPw(String userId, String userPw, String newPw) {
		if(userPw.equals("")) {
			//임시 비밀번호로 바꿈
			return dao.updateUserPw(userId, newPw);
			
		}else {
			//평소 비밀번호 변경
			return false;
		}
	}
}
