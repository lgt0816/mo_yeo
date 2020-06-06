package com.sungkyul.graduation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActivityPlanStatus {
	private int planStatusId;
	private String planStatusTitle;
	private String planStatusContents;
	
}
