package com.myproject.japanese.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;

@Getter
public class FileInfo {
	private String fileName;
	private String contentType;
	
	public FileInfo(MultipartFile file) {
		this.fileName = file.getOriginalFilename().split("\\.")[0];
		this.contentType = file.getContentType();
	}

}
