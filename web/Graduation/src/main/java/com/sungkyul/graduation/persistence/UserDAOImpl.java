package com.sungkyul.graduation.persistence;

import javax.inject.Inject;

import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sungkyul.graduation.domain.User;
import com.sungkyul.graduation.dto.FindUserIdDTO;
import com.sungkyul.graduation.dto.JoinDTO;
import com.sungkyul.graduation.dto.LoginDTO;
import com.sungkyul.graduation.dto.UserUpdateDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Inject
	private SqlSession session;
	
	private static final String NS = "com.sungkyul.graduation.persistence.UserMapper";
	private static final String LOGIN = NS+".login";
	private static final String JOIN = NS+".join";
	private static final String CHECK_EMAIL = NS+".checkEmail";
	private static final String CHECK_USER_ID = NS+".checkUserId";
	private static final String UPDATE_USER_PW =NS+".updateUserPw";
	private static final String UPDATE_USER_PW2 =NS+".updateUserPw2";
	private static final String UPDATE_USER=NS+".updateUser";
	private static final String FIND_USER_ID=NS+".findUserId";
	

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

	//비밀번호 + 개인정보 변경
	@Override
	public User updateUserPw(UserUpdateDTO userUpdateDTO) {

		//update는 리턴시 바꾸는데 성공한 row 갯수를 반환한다.(resultType없음)
		if(session.update(UPDATE_USER_PW, userUpdateDTO) != 0) {
			//성공시
			LoginDTO loginDTO= new LoginDTO(userUpdateDTO.getUserId(), 
					userUpdateDTO.getUserPw3());
			return session.selectOne(LOGIN, loginDTO);
		}else {
			//실패시
			return null;
		}
		
	}

	@Override
	//개인정보만 변경
	public User updateUser(UserUpdateDTO userUpdateDTO) {
		//update는 리턴시 바꾸는데 성공한 row 갯수를 반환한다.(resultType없음)
		if (session.update(UPDATE_USER, userUpdateDTO) != 0) {
			// 성공시
			LoginDTO loginDTO = new LoginDTO(userUpdateDTO.getUserId(), userUpdateDTO.getUserPw1());
			return session.selectOne(LOGIN, loginDTO);
		} else {
			// 실패시
			return null;
		}
	}

	@Override
	public String findUserId(FindUserIdDTO findIdDTO) {
		String result = session.selectOne(FIND_USER_ID,findIdDTO);
		System.out.println(result);
		return result;
	}

	@Override
	public boolean updateUserPw(String userId, String newPw) {
		LoginDTO tempDTO = new LoginDTO(userId, newPw);
		
		return (session.update(UPDATE_USER_PW2, tempDTO)) == 0 ? false : true;
	}
}
