package com.sungkyul.graduation.dto;

import lombok.Data;

@Data
public class JoinDTO {
	private String userId;
	private String userPw;
	private String name;
	private String phoneNum;
	private String email;
	private String sex;
	private String major;	//전공
	private int grade;		//학년
	private String schoolState;	//재학상태(재학, 휴학, 졸업)
}
