package com.sungkyul.graduation.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sungkyul.graduation.domain.Activity;
import com.sungkyul.graduation.domain.ActivityFile;
import com.sungkyul.graduation.domain.ActivityPlan;
import com.sungkyul.graduation.domain.ActivityPlanStatus;
import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.domain.Portfolio;
import com.sungkyul.graduation.persistence.ActivityDAOImpl;
import com.sungkyul.graduation.persistence.PortfolioDAOImpl;
import com.sungkyul.graduation.service.ActivityService;
import com.sungkyul.graduation.util.Aes256;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class JoinDtoToStudentTest {
	
	@Inject private ActivityDAOImpl activityDAO;
	@Inject private Aes256 aes256;
	@Inject private PortfolioDAOImpl portfolioDAO;
	@Inject private ActivityService activityService;
	
	@Test
	public void toStudent() throws Exception{
//		JoinDTO testJoinDTO = new JoinDTO.JoinDTOBuilder()
//				.userId("1234")
//				.userPw("qlalfqjsgh")
//				.name("이근택")
//				.phoneNum("010-1234-5678")
//				.sex("men")
//				.schoolType("공과대")
//				.major("컴공")
//				.grade(4)
//				.schoolState("휴학")
//				.email1("1234")
//				.email2("sungkyul.ac.kr")
//				.build();
//		System.out.println(testJoinDTO.toString());
//		
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.addMappings(new PropertyMap<JoinDTO, Student>() {
//			@Override
//			protected void configure() {
//				map().setEmail(source.getEmail1()+"@"+source.getEmail2());
//			}
//		});
//		Student student = modelMapper.map(testJoinDTO, Student.class);
//		System.out.println(student.toString());
//		MentorCareer career = new MentorCareer("타이틀", "입사시간", "퇴사시간");
//		TestDTO testDTO = modelMapper.map(career, TestDTO.class);
//		System.out.println(testDTO.toString());
		
//		for(int i=0 ; i<5; i++) {
//			Activity activity = new Activity(i);
//			System.out.println(activity.toString());
//		}
		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userId", "20130946");
//		paramMap.put("activityId", "1");
//		paramMap.put("result", "결과입니다");
//		paramMap.put("thought", "소감입니다");
//		CompletedActivity test = activityDAO.selectActivity(paramMap);
//		System.out.println(test.toString());
//		ArrayList<String> test = (ArrayList<String>) activityDAO.selectParticipants(paramMap);
//		System.out.println(test.toString());
		
//		HashMap<String, Object> test =  (HashMap<String, Object>) activityDAO.selectOneResult(paramMap);
//		System.out.println(test==null);
//		System.out.println(paramMap.values());
//		
//		boolean test =activityDAO.updateResult(paramMap);
//		System.out.println(test);
		
//		List<Portfolio> result =
//				portfolioDAO.selectPortfolios("20130946");
//		for(int i=0; i<result.size();i++) {
//			String portfolioId = Integer.toString(result.get(i).getPortfolioId()); 
//			List<CompletedActivity> activitys = 
//					portfolioDAO.selectIncludedACT(portfolioId);
//			for(int j=0 ; j<activitys.size();j++) {
//				aes256.encodingActivity(activitys.get(j));
//			}
//			result.get(i).setActivitys((ArrayList<CompletedActivity>) activitys);
//		}
		
//		List<Portfolio> result =
//				portfolioDAO.selectPortfolios("20130946");
//		//포트폴리오 갯수만큼 돌림
//		for(int i=0; i<result.size();i++) {
//			String portfolioId = Integer.toString(result.get(i).getPortfolioId()); 
//			List<CompletedActivity> activitys = 
//					portfolioDAO.selectIncludedACT(portfolioId);
//			//포트폴리오에 등록된 활동들의 id를 암호화후 URL형식으로 인코딩함
//			for(int j=0 ; j<activitys.size();j++) {
//				aes256.encodingActivity(activitys.get(j));
//			}
//			result.get(i).setActivitys((ArrayList<CompletedActivity>) activitys);
//		}
		
//		System.out.println(result.toString());
		
//		Map<String, Object> testMap = new HashMap<String, Object>();
//		testMap.put("portfolioId", "1");
//		testMap.put("userId", "20130946");
//		testMap.put("portfolioTitle", "수정");
//		if(portfolioDAO.updataPortfolioTitle(testMap)) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userId", "20130946");
//		paramMap.put("portfolioId","5");
//		Portfolio test = portfolioDAO.selectPortfolio(paramMap);
//		
//		System.out.println(test.toString());
		
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fileId", "11");
		paramMap.put("userId", "20130946");
		
		boolean result = activityDAO.deleteActivityFile(paramMap);
		System.out.println(result);
		
		
		
		
	}

}
