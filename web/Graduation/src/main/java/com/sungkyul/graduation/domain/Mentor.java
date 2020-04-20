package com.sungkyul.graduation.domain;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mentor extends User{
	ArrayList<MentorCareer> careers;

	public Mentor(String userId, String userPw, String name, String phoneNum, String email, String sex) {
		super(userId, userPw, name, phoneNum, email, sex);
	}
	
	public Mentor(String userId, String userPw, String name, String phoneNum, String email, String sex, ArrayList<MentorCareer> careers) {
		super(userId, userPw, name, phoneNum, email, sex);
		this.careers=careers;
	}
	
}
