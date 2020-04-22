package com.sungkyul.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class FindUserPwDTO extends FindUserIdDTO{
	String userId;

	@Builder
	public FindUserPwDTO(String name, String userId, String email1, String email2) {
		super(name, email1, email2);
		this.userId = userId;
	}
}
