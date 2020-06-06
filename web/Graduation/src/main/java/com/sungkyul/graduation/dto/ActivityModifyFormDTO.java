package com.sungkyul.graduation.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
public class ActivityModifyFormDTO {
	
//	private String activityId;
	private String result;	//결과
	private String thought;	//소감
	private String activityType;
	private String activityTitle;
	private List<MultipartFile> files;
	
	private String encodedId;	//암호화된 활동 id
	
}
