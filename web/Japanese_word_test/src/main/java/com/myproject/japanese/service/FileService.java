package com.myproject.japanese.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;


public interface FileService {
	public static final String TAILFILENAME="_WordTest";	//파일 다운로드시 파일명 뒤에 붙일 이름(TailFileName)
	
	//파일 다운로드
	public void doFileDownload(HttpServletResponse response, MultipartFile file) throws Exception;

	//서비스 단에서 하는것이 아니지만 일딴 집어넣음	
//	public HttpServletResponse makePdfFile(HttpServletResponse response, JapanesWordLists words);
//	JapanesWordLists convertToList(MultipartFile file);

}
