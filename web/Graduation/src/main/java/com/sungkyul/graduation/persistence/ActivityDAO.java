package com.sungkyul.graduation.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sungkyul.graduation.domain.ActivityFile;
import com.sungkyul.graduation.domain.ActivityPlan;
import com.sungkyul.graduation.domain.ActivityPlanStatus;
import com.sungkyul.graduation.domain.ActivityResult;
import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.dto.ActivityModifyFormDTO;

public interface ActivityDAO {

	List<CompletedActivity> selectActivitys(Map<String, Object> paramMap);

	CompletedActivity selectActivity(Map<String, Object> paramMap);

	List<String> selectParticipants(Map<String, Object> paramMap);

	Map<String, Object> selectOneResult(Map<String, Object> paramMap);

	boolean insertResult(Map<String, Object> paramMap);

	boolean updateResult(Map<String, Object> paramMap);

	List<CompletedActivity> selectAllActivitys(String userId);

	ActivityResult selectActivityResult(Map<String, Object> paramMap);

	List<ActivityPlan> selectActivityPlans(String decodedId);

	List<ActivityPlanStatus> selectActivityPlanStatusList(Map<String, Object> _paramMap);

	boolean insertActivityFile(Map<String, Object> paramMap);

	List<ActivityFile> selectActivityFiles(Map<String, Object> paramMap);

	ActivityFile selectActivityFile(Map<String, Object> paramMap);

	boolean deleteActivityFile(Map<String, Object> paramMap);

}
