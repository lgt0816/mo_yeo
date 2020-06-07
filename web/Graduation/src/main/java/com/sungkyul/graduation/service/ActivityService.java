package com.sungkyul.graduation.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.sungkyul.graduation.domain.Activity;
import com.sungkyul.graduation.domain.ActivityFile;
import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.dto.ActivityModifyFormDTO;

public interface ActivityService {

	Map<Integer, List<CompletedActivity>> getActivitys(String userId, String activityType);

	Activity getActivity(String loginedUserId, String encodedId);

	boolean updateActivityResult(ActivityModifyFormDTO activityModifyFormDTO, String userId);

	List<CompletedActivity> getAllActivity(String userId);

	boolean uploadActivityFiles(String loginedUserId, ActivityModifyFormDTO activityModifyFormDTO);

	boolean deleteActivityFile(String loginedUserId, String fileId);

	ActivityFile getActivityFile(String fileId);

	File getActivityRealFile(ActivityFile activityFile);

//	InputStream getActivityRealFile(ActivityFile activityFile);
	

}
