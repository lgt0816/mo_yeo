package com.sungkyul.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserUpdateDTO {
	String userId;
	String userPw1;
	String userPw2;
	String userPw3;
	String phoneNum;
	String schoolType;
	String major;
	String grade;
	String schoolState;
}
