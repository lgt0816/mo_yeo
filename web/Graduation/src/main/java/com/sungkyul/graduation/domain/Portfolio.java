package com.sungkyul.graduation.domain;

import java.util.ArrayList;

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
public class Portfolio {
	private int portfolioId;
	private String title;
	private ArrayList<CompletedActivity> activitys;
	
	private String encodedId;
}
