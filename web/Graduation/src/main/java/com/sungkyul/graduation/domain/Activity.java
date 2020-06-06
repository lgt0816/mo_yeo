package com.sungkyul.graduation.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Activity {
	private int activityId;	
	private String title;
	private String subTitle;
	private String contents;
	private String created;
	private String author;	//팀장(저자)
	private ArrayList<String> participants;	//참여자들 이름
	private List<ActivityPlan> activityPlans;	//활동계획들
	private String activityType;
	
	private String encodedId;
	
	public Activity(int activityId, String title, String subTitle, String contents, 
			String created, String author, String activityType) {
		this.activityId = activityId;
		this.title = title;
		this.subTitle = subTitle;
		this.contents = contents;
		this.created = created;
		this.author = author;
		this.activityType = activityType;
	}
	
}
