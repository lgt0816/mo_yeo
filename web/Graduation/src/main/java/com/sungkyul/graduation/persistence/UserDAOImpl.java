package com.sungkyul.graduation.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Inject
	private SqlSession session;
	
	private static final String NS = "com.sungkyul.graduation.persistence.UserMapper";
	private static final String LOGIN = NS+".login";
	private static final String JOIN = NS+".join";
	private static final String CHECK_EMAIL = NS+".checkEmail";
	private static final String CHECK_USER_ID = NS+".checkUserId";

	@Override
	public User login(LoginDTO dto) throws Exception {
		
		return session.selectOne(LOGIN, dto);
	}

	@Override
	public boolean join(JoinDTO dto) throws Exception {
		try {
			session.insert(JOIN, dto);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	@Override
	public boolean checkEmail(String email) throws Exception{
		if(session.selectOne(CHECK_EMAIL, email)==null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean checkUserId(String userId) throws Exception {
		if(session.selectOne(CHECK_USER_ID,userId)==null) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
