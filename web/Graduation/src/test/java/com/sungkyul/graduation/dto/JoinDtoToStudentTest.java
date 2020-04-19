package com.sungkyul.graduation.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sungkyul.graduation.domain.MentorCareer;
import com.sungkyul.graduation.mapstruct.CareerMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class JoinDtoToStudentTest {
	
//	@Inject
//	StudentMapper mapStruct;
	

	
	
	@Test
	public void toStudent() throws Exception{
		CareerMapper careerMapper= Mappers.getMapper(CareerMapper.class);
//		JoinDTO testJoinDTO = new JoinDTO.JoinDTOBuilder()
//				.userId("1234")
//				.userPw("1234")
//				.name("1111")
//				.phoneNum("1111")
//				.sex("men")
//				.schoolType("공과대")
//				.major("컴공")
//				.grade(4)
//				.schoolState("휴학")
//				.email1("1234")
//				.email2("1234")
//				.build();
//		System.out.println(testJoinDTO.toString());
		MentorCareer career = new MentorCareer("타이틀", "입사시간", "퇴사시간");
		System.out.println(career.toString());
		TestDTO testDTO = careerMapper.toTestDTO(career);
		System.out.println(testDTO.toString());
	}

}
