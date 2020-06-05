package com.sungkyul.graduation.service;

import java.util.List;
import java.util.Map;

import com.sungkyul.graduation.domain.Activity;
import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.dto.ActivityModifyFormDTO;

public interface ActivityService {

	Map<Integer, List<CompletedActivity>> getActivitys(String userId, String activityType);

	Activity getActivity(String loginedUserId, String encodedId);

	boolean updateActivityResult(ActivityModifyFormDTO activityModifyFormDTO, String userId);

	List<CompletedActivity> getAllActivity(String userId);
	

}
