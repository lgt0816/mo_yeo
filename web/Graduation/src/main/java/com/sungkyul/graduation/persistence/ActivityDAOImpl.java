package com.sungkyul.graduation.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sungkyul.graduation.controller.ActivityController;
import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.dto.ActivityModifyFormDTO;

@Repository
public class ActivityDAOImpl implements ActivityDAO {

	@Inject
	private SqlSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(ActivityDAOImpl.class);
	
	private static final String NS = "com.sungkyul.graduation.persistence.ActivityMapper";
	private static final String SELECT_ACTIVITYS = NS+".selectActivitys";
	private static final String SELECT_ACTIVITY = NS+".selectActivity";
	private static final String SELECT_PARTICIPANTS = NS+".selectParticipants";
	private static final String SELECT_ONE_RESULT = NS+".selectOneResult";
	private static final String INSERT_RESULT = NS+".insertResult";
	private static final String UPDATE_RESULT = NS+".updateResult";
	private static final String SELECT_ALL_ACTIVITYS = NS+".selectAllActivitys";
	
	@Override
	public List<CompletedActivity> selectActivitys(Map<String, Object> paramMap) {
		List<CompletedActivity> resultActivity 
			= session.selectList(SELECT_ACTIVITYS, paramMap);
		logger.info("selected Activitys :{}", resultActivity.toString());
		
		return resultActivity; 
	}

	@Override
	public CompletedActivity selectActivity(Map<String, Object> paramMap) {
		CompletedActivity resultActivity 
			= session.selectOne(SELECT_ACTIVITY, paramMap);
		return resultActivity;
	}

	@Override
	public List<String> selectParticipants(Map<String, Object> paramMap) {
		List<String> resultParticipants =
				session.selectList(SELECT_PARTICIPANTS, paramMap);
		return resultParticipants;
	}
	
	
	@Override
	public Map<String, Object> selectOneResult(Map<String, Object> paramMap){
		Map<String, Object> result = 
				session.selectOne(SELECT_ONE_RESULT, paramMap);
		
		return result;
	}

	@Override
	public boolean insertResult(Map<String, Object> paramMap) {
		
		return (session.insert(INSERT_RESULT, paramMap)==0) ? false:true;
		
	}

	@Override
	public boolean updateResult(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		
		return (session.update(UPDATE_RESULT, paramMap)==0) ? false:true;
	}
	
	
	@Override
	public List<CompletedActivity> selectAllActivitys(String userId) {
		List<CompletedActivity> result = 
				session.selectList(SELECT_ALL_ACTIVITYS, userId);
		
		return result;
	}
	
	
}
