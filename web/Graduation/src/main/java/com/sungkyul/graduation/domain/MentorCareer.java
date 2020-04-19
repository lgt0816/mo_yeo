package com.sungkyul.graduation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class MentorCareer {
	private String careerTitle;
	private String startDay;
	private String finishDay;
}
