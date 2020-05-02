package com.sungkyul.graduation.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sungkyul.graduation.domain.MentorCareer;
import com.sungkyul.graduation.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class JoinDtoToStudentTest {
	
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
		
	}

}
