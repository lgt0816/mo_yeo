package com.sungkyul.graduation.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.domain.Portfolio;
import com.sungkyul.graduation.persistence.PortfolioDAO;
import com.sungkyul.graduation.util.Aes256;

@Service
public class PortfolioServiceImpl implements PortfolioService{

	@Inject private PortfolioDAO portfolioDAO;
	@Inject private Aes256 aes256;
		
	//포트폴리오들을 반환(포트폴리오에 연결되있는 활동들 포함)
	@Override
	public List<Portfolio> getPortfolios(String loginedUserId) {
		
		List<Portfolio> result =
				portfolioDAO.selectPortfolios(loginedUserId);
		
		//포트폴리오 갯수만큼 돌림
		for(int i=0; i<result.size();i++) {
			String portfolioId = Integer.toString(result.get(i).getPortfolioId());
			aes256.encodingPortfolio(result.get(i));	//포트폴리오 id를 암호화 후 URL형식으로 인코딩(encodedId)
			List<CompletedActivity> activitys = 
					portfolioDAO.selectIncludedACT(portfolioId);
			//포트폴리오에 등록된 활동들의 id를 암호화후 URL형식으로 인코딩함
			for(int j=0 ; j<activitys.size();j++) {
				aes256.encodingActivity(activitys.get(j));
			}
			result.get(i).setActivitys((ArrayList<CompletedActivity>) activitys);
		}
		
		return result;
	}
	
	@Override
	public boolean createPortfolio(String userId, String portfolioTitle) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("portfolioTitle", portfolioTitle);
				
		return portfolioDAO.insertPortfolio(paramMap);
	}
	
	//테스트 해봐야됨
	@Override
	public boolean createPortfolio(String userId, String portfolioTitle, 
			String[] activityIds) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		
		if(createPortfolio(userId, portfolioTitle)) {
			String portfolioId;
			portfolioId=
					portfolioDAO.selectCurrentPortfolioId(userId);
			for(int i=0; i<activityIds.length;i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String encodedId = URLDecoder.decode(activityIds[i],"UTF-8") ;
				String activityId = aes256.decrypt(encodedId);
				
				paramMap.put("userId", userId);
				paramMap.put("portfolioId", portfolioId);
				paramMap.put("activityId", activityId);
				
				if(!portfolioDAO.insertIncludedACT(paramMap)) return false;
			}
			
			return true;
		}else 
			return false;
		
	}
	
	//테스트 해봐야됨
	@Override
	public boolean deletePortfolio(String userId, String encodedId) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String portfolioId = aes256.decrypt(encodedId);
			paramMap.put("userId", userId);
			paramMap.put("portfolioId", portfolioId);
			
			if(portfolioDAO.deleteAllIncludedACT(paramMap)) {
				return portfolioDAO.deletePortfolio(paramMap);
			}else
				return false;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Portfolio getPortfolio(String userId, String encodedId) {
		
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String portfolioId = aes256.decrypt(encodedId);
			paramMap.put("userId", userId);
			paramMap.put("portfolioId", portfolioId);
			
			Portfolio result = portfolioDAO.selectPortfolio(paramMap);
			result.setActivitys((ArrayList<CompletedActivity>) portfolioDAO.selectIncludedACT(portfolioId));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	//테스트 해봐야됨
	@Override
	public boolean modifyPortfolioTitle(String userId, String urlEncodedId, String portfolioTitle) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String encodedId = URLDecoder.decode(urlEncodedId, "UTF-8");
			String portfolioId = aes256.decrypt(encodedId);
		
			paramMap.put("portfolioId", portfolioId);
			paramMap.put("userId", userId);
			paramMap.put("portfolioTitle", portfolioTitle);
			
			return portfolioDAO.updataPortfolioTitle(paramMap);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean modifyIncludedActivity(String userId, String urlEncodedId, 
			String[] encodedACTIds){
		try {
		String encodedId = URLDecoder.decode(urlEncodedId, "UTF-8");
		String portfolioId = aes256.decrypt(encodedId);
		
		//deleteAllIncludedACT 의 파라미터
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("portfolioId", portfolioId);

		//포함되어 있는 활동들을 제거한다.
		if(portfolioDAO.deleteAllIncludedACT(paramMap)) {
			//선택된 활동들을 포트폴리오에 연결한다.
			for(int i=0; i<encodedACTIds.length;i++) {
				Map<String, Object> _paramMap = new HashMap<String, Object>();
				String _encodedId = URLDecoder.decode(encodedACTIds[i],"UTF-8");
				String _activityId = aes256.decrypt(_encodedId);
				
				_paramMap.put("userId", userId);
				_paramMap.put("portfolioId", portfolioId);
				_paramMap.put("activityId", _activityId);
				
				if(!portfolioDAO.insertIncludedACT(_paramMap)) return false;
			}
		}
		
		return true;
		
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
	@Override
	public boolean modifyIncludedActivity(String userId, String urlEncodedId) {
		try {
			String encodedId = URLDecoder.decode(urlEncodedId, "UTF-8");
			String portfolioId = aes256.decrypt(encodedId);
			
			//deleteAllIncludedACT 의 파라미터
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", userId);
			paramMap.put("portfolioId", portfolioId);
			
			return portfolioDAO.deleteAllIncludedACT(paramMap);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	
	
	

}
