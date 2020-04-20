package com.myproject.japanese.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.japanese.service.FileService;

@Controller
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Inject
	private FileService fileService;
	
	@RequestMapping(value = "/inputFile", method=RequestMethod.GET)
	public void inputFile() {
		logger.info("please input your css File!");
	}
	@RequestMapping(value = "/postInputFile", method=RequestMethod.POST)
	public void inputFilePost(HttpServletResponse response, @RequestParam("file") MultipartFile file) throws Exception {
		fileService.doFileDownload(response, file);

	}

}
