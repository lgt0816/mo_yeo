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
		InputStream file = null;
		BufferedInputStream binput=null;
		BufferedOutputStream boutput = null;
		
		if(fileController.ftpConnect()) {
			long fileSize = fileController.getFileSize("/home/graduation/6최종보고서_8조.hwp");
			long percent = fileSize/5120;
			
//			InputStream file = new FileInputStream(new File("D:\\6최종보고서_8조.hwp"));
//			fileController.ftpFileUpload("/home/graduation/", "6최종보고서_8조.hwp", file);
//			fileController.ftpFileDelete("/home/graduation/", "6최종보고서_8조.hwp");
			
			file = fileController.getFtpFileInputStream("/home/graduation/", "6최종보고서_8조.hwp");
			binput = new BufferedInputStream(file);
			boutput = new BufferedOutputStream(new FileOutputStream(new File("D:\\testDownload\\6최종보고서_8조.hwp")));
			int i;
			int bufferCount =0;
			int count = 10;
			byte[] buffer = new byte[512];
			
			while ((i= binput.read(buffer))!=-1){
                boutput.write(buffer,0,i);
                bufferCount+=1;
                if(bufferCount >= percent ){
                    System.out.println("다운로드  :"+count+"%");
                    count+=10;
                    bufferCount =0;
                }
            }
			
			fileController.ftpDisconnect();
			file.close();
		}
	}
	
}
