package com.sungkyul.graduation.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;
import com.sungkyul.graduation.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDAO dao;

	@Override
	public User login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
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
}
