package com.sungkyul.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserUpdatePwDTO {
	String userId;
	String userPw1;
	String userPw2;
	String newPw;
}
