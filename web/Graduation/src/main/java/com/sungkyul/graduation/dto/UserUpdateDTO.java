package com.sungkyul.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserUpdateDTO {
	String userId;
	String userPw1;
	String userPw2;
	String newPw;
	String phoneNum;
	String schoolType;
	String major;
	String grade;
	String schoolState;
	
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
