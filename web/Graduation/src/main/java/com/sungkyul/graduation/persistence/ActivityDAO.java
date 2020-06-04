package com.sungkyul.graduation.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sungkyul.graduation.domain.CompletedActivity;
import com.sungkyul.graduation.dto.ActivityModifyFormDTO;

public interface ActivityDAO {

	List<CompletedActivity> selectActivitys(Map<String, Object> paramMap);

	CompletedActivity selectActivity(Map<String, Object> paramMap);

	List<String> selectParticipants(Map<String, Object> paramMap);

	Map<String, Object> selectOneResult(Map<String, Object> paramMap);

	boolean insertResult(Map<String, Object> paramMap);

	boolean updateResult(Map<String, Object> paramMap);

}
