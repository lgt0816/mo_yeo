package com.sungkyul.graduation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class User {
	private String userId;
	private String userPw;
	private String name;
	private String phoneNum;
	private String email;
	private String sex;
//	private String major;	//전공
//	private int grade;		//학년
//	private String schoolState;	//재학상태(재학, 휴학, 졸업)
//	private int totalWarningCount;	//총 경고 횟수

}
