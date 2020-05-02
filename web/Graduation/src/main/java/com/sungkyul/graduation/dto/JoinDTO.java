package com.sungkyul.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class JoinDTO {
	private String userId;
	private String userPw1;
	private String userPw2;
	private String name;
	private String phoneNum;
	private String email;
	private String email1;
	private String email2;
	private String sex;
	private String schoolType;	//대학(공과대학, 사범대학 etc...)
	private String major;	//전공
	private String grade;		//학년
	private String schoolState;	//재학상태(재학, 휴학, 졸업)
	
	public String getEmail() {
		return email1+"@"+email2;
	}
	
	public int getGrade() {
		int tempGrade=0;
		try {
			switch(grade) {
			case "1학년":
				tempGrade=1;
				break;
			case "2학년":
				tempGrade=2;
				break;
			case "3학년":
				tempGrade=3;
				break;
			case "4학년":
				tempGrade=4;
				break;
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return tempGrade;
	}

}
