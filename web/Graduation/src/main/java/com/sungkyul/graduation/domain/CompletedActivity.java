package com.sungkyul.graduation.domain;

import java.util.ArrayList;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class CompletedActivity extends Activity {
	private String startDay;
	private String endDay;
	private Boolean completed;	//완전히 완료한 활동(True)인지 중도헤체된 활동인지 확인
	private ActivityResult activityResult;	//활동결과 및 소감
	private ArrayList<ActivityFile> files;	//업로드한 파일
	private int completedUserGrade; //완료한 시점의 사용자 학년
	
//	@Builder
//	public CompletedActivity(int activityId, String title, String subTitle, String contents, String created, 
//			String author, String activityType, String startDay, String endDay, Boolean completed,
//			int comppetedUserGrade) {
//		super(activityId, title, subTitle, contents, created, author, activityType);
//		this.startDay = startDay;
//		this.endDay=endDay;
//		this.completed = completed;
//		this.completedUserGrade=comppetedUserGrade;
//	}
//	
//	public CompletedActivity(int activityId, String title, String subTitle, String contents, String created, 
//			String author, String activityType, String startDay, String endDay, Boolean completed,
//			String result, String thought, ArrayList<File> files,
//			int comppetedUserGrade) {
//		super(activityId, title, subTitle,contents, created, author, activityType);
//		this.startDay = startDay;
//		this.endDay=endDay;
//		this.completed = completed;
//		this.result = result;
//		this.thought = thought;
//		this.files = files;
//		this.completedUserGrade=comppetedUserGrade;
//	}
	
}
