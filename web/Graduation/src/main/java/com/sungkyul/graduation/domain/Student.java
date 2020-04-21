package com.sungkyul.graduation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Student extends User {
	private String schoolType; //대학(공과대학, 사범대학 etc...)
	private String major;	//전공
	private int grade;		//학년
	private String schoolState;	//재학상태(재학, 휴학, 졸업)
	private int totalWarningCount;	//총 경고 횟수
	
	@Builder
	public Student(String userId, String userPw, String name, String phoneNum, String email, String sex,
			String schoolType, String major, int grade, String schoolState, int totalWarningCount) {
		super(userId, userPw, name, phoneNum, email, sex);
		this.schoolType = schoolType;
		this.major = major;
		this.grade = grade;
		this.schoolState = schoolState;
		this.totalWarningCount = totalWarningCount;
	}
	
	
}
