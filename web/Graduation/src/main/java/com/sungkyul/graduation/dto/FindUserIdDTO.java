package com.sungkyul.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FindUserIdDTO {
	String name;
	String email1;
	String email2;
	String email;
	
	public FindUserIdDTO(String name, String email1, String email2) {
		this.name = name;
		this.email1 = email1;
		this.email2 = email2;
		this.email = email1+"@"+email2;
	}
	
	public String getEmail() {
		return this.email1+"@" + this.email2;
	}
	
	
	
}
