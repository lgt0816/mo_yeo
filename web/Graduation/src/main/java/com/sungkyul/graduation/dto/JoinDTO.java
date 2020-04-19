package com.sungkyul.graduation.dto;

import lombok.Builder;
import lombok.Data;


@Data
public class JoinDTO {
	private String userId;
	private String userPw;
	private String name;
	private String phoneNum;
	private String email[];
	private String sex;
	private String schoolType;	//대학(공과대학, 사범대학 etc...)
	private String major;	//전공
	private int grade;		//학년
	private String schoolState;	//재학상태(재학, 휴학, 졸업)
	
	@Builder
	public JoinDTO(String userId, String userPw, String name, String phoneNum, String email1, String email2, String sex, String schoolType,
			String major, int grade, String schoolState) {
		this.email = new String[3];
		this.email[1] = "@";
		
		this.userId = userId;
		this.userPw = userPw;
		this.name = name;
		this.phoneNum = phoneNum;
		this.email[0] = email1;
		this.email[2] = email2;
		this.sex = sex;
		this.schoolType=schoolType;
		this.major = major;
		this.grade = grade;
		this.schoolState = schoolState;
	}
	
	
}
