package com.sungkyul.graduation.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.SocketException;

import javax.inject.Inject;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Controller;



@Controller
public class FileController {

	public static final String FTP_HOST ="dlrmsxortest.asuscomm.com";
	private static final String FTP_USER_ID = "sungkyul";
	private static final String FTP_USER_PW = "sungkyul";
	public static final String FTP_MAIN_PATH = "/home/graduation";
	
	@Inject private FTPClient ftpClient;
	
	//ftpClient로 서버 접속
	public Boolean ftpConnect() {
		ftpClient.setControlEncoding("UTF-8");
		ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		
        try {
			ftpClient.connect(FTP_HOST);
			reply = ftpClient.getReplyCode();
	        if (!FTPReply.isPositiveCompletion(reply)) {
	            ftpClient.disconnect();
	            return false;
	        }
	        ftpClient.login(FTP_USER_ID, FTP_USER_PW);//로그인
	        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	        ftpClient.enterLocalPassiveMode();
	        
	        return true;
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//서버에서 로그아웃 및 접속 종료
	public void ftpDisconnect() {
		if (ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException f) {
                f.printStackTrace();
            }
        }
	}
	
	//ftp서버로 파일 업로드
	
	/* @Param serverFilePath : 파일명을 포함하지 않는 path
	 * @Param fileName : 파일명
	 * @Param file	: 파일 인풋스트림 why? 멀티파트파일을 innputStream으로 변환하기 때문
	 */
	public void ftpFileUpload(String serverFilePath, String fileName, InputStream file) {
		try {
			makeUserDirectory(serverFilePath);	//디렉토리가 존재하지 않는경우 만듬
			Boolean result = ftpClient.storeFile(serverFilePath+fileName, file);	//업로드 결과
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ftp서버의 파일 삭제
	public void ftpFileDelete(String serverFilePath, String fileName) {
		try {
			Boolean result = ftpClient.deleteFile(serverFilePath+fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ftp서버에서 파일 다운로드시 해당 파일의 인풋스트림을 반환
//	public InputStream getFtpFileInputStream(String serverFilePath, String fileName) {
//		try {
//			
//			return ftpClient.retrieveFileStream(serverFilePath+fileName);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public File getFile(String serverFilePath, String fileName) {
		File file = null;
		try {
			if(ftpConnect()) {
				file=new File(fileName);
				OutputStream os = new FileOutputStream(file);
				InputStream is = ftpClient.retrieveFileStream(serverFilePath+fileName);
				is.transferTo(os);
				ftpDisconnect();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
		
		
	}
	
	public long getFileSize(String fileName){
        long fileSize = 0;
        FTPFile[] files = null;
        try {
            files = ftpClient.listFiles();
            for(FTPFile file : files){
                if(file.getName().equals(fileName)){
                    fileSize =file.getSize();
                    return fileSize;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileSize;
    }
	
	//해당 디렉토리를 ftp서버에 만듬
	public void makeUserDirectory(String serverDirPath) throws IOException {
		String[] paths = serverDirPath.split("/");
		StringBuffer tempPath = new StringBuffer();
		
		if(ftpClient.isConnected()) {
			//paths[0]="" 이므로 1부터 시작 globalPath : /home/graduation/
			for(int i=1; i<paths.length;i++) {
				tempPath.append("/"+paths[i]);
				if(ftpClient.changeWorkingDirectory(tempPath.toString())) {
					ftpClient.changeWorkingDirectory("/");	//디렉토리가 존재하면 루트로 돌아옴
				}else {
					ftpClient.makeDirectory(tempPath.toString());	//디렉토리가 존재하지 않으면 만듬
				}
			}
		}else {
			System.out.println("ftpClient is not Connected...");
			throw new IOException();
		}
		
	}
	
}
