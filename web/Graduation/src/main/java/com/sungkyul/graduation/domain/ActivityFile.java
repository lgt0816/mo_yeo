package com.sungkyul.graduation.domain;

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
public class ActivityFile {
	private int fileId;
	private String fileName;
	private String fileSize;
	private String filePath;
	private String fileDate;
	
	private String encodedId;

//	public File(int fileId, String filName, String fileSize, String filePath, String fileDate) {
//		this.fileId = fileId;
//		this.fileName = filName;
//		this.fileSize = fileSize;
//		this.filePath = filePath;
//		this.fileDate = fileDate;
//	}
	
}
