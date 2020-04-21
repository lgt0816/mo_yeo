package com.sungkyul.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class JoinDTO {
	private String userId;
	private String userPw;
	private String name;
	private String phoneNum;
	private String email1;
	private String email2;
	private String sex;
	private String schoolType;	//대학(공과대학, 사범대학 etc...)
	private String major;	//전공
	private int grade;		//학년
	private String schoolState;	//재학상태(재학, 휴학, 졸업)

}
