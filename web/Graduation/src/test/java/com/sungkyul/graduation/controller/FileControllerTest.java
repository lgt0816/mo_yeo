package com.sungkyul.graduation.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.FileUrlResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class FileControllerTest {
	
	@Inject FileController fileController;
	
	@Test
	public void ftpConnectTest() throws IOException {
		if(fileController.ftpConnect()) {
			File testFile = new File("D:\\6최종보고서_8조.hwp");
			FileInputStream testInputStream = new FileInputStream(testFile);
			
			String FTPUrl = fileController.FTP_MAIN_PATH+"/이근택/스터디/20130946/";
			fileController.ftpFileUpload(FTPUrl, "6최종보고서_8조.hwp", testInputStream);
			fileController.ftpDisconnect();
		}
	}
	
}
