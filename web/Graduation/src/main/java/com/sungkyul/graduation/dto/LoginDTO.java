package com.sungkyul.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {
	private String userId;
	private String userPw;
}
