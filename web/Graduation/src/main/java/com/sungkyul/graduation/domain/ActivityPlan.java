package com.sungkyul.graduation.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivityPlan {
	private int planId;
	private String planTitle;
	private String planContents;
	private String planStartDay;
	private String planEndDay;
	private List<ActivityPlanStatus> planStatusList;

}
