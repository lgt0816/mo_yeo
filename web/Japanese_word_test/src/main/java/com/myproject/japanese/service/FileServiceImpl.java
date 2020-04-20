package com.myproject.japanese.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.codec.Base64.InputStream;
import com.myproject.japanese.document.PdfHelper;
import com.myproject.japanese.domain.FileInfo;
import com.myproject.japanese.domain.JapanesWordLists;
import com.myproject.japanese.domain.Kannzi;
import com.myproject.japanese.domain.Katakana;
import com.myproject.japanese.domain.Word;
import com.myproject.japanese.domain.WordTypes;
import com.opencsv.CSVReader;

@Service
public class FileServiceImpl implements FileService, WordTypes{

	@Override
	public void doFileDownload(HttpServletResponse response, MultipartFile file) throws Exception{
		FileInfo fileInfo = new FileInfo(file);
		JapanesWordLists words = convertToList(file);
		response.setHeader("Content-Disposition", "inline;filename="+fileInfo.getFileName()+".pdf;");
		response.setContentType("application/pdf");
		
		makePdfFile(response, words, fileInfo);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	//구현완료
	public JapanesWordLists convertToList(MultipartFile file) {
		int wordType= -1;
		JapanesWordLists wordLists = new JapanesWordLists();
		
		
		InputStreamReader inputStreamReader =null;
		CSVReader reader=null;
		
        
        List<String[]> list;
		
        try {
        	//인풋스트림 리더의 인코딩을 UTF-8로 설정
        	inputStreamReader = new InputStreamReader(file.getInputStream(), "UTF-8");
			reader = new CSVReader(inputStreamReader);
			list = reader.readAll();
			
			OutLoop : for (String[] outForStr : list) {
				
				//단어 타입을 확인함
				for(int inForInt=0; inForInt<wordTypes.length; inForInt++) {
					if(outForStr[0].replaceAll(" ", "").equals(wordTypes[inForInt]) || 
							outForStr[1].replace(" ", "").equals(wordTypes[inForInt])) {
						wordType=inForInt;
						continue OutLoop;
					}
				}
				
				Word entity;
				//테스트
//				entity = new Kannzi(outForStr[0], outForStr[1], outForStr[2]);
//				wordLists.getList().add(entity);
//				System.out.println(entity.toString());
				
				switch(wordType){
					case 0:
						entity = new Kannzi(outForStr[0], outForStr[1], outForStr[2]);
						wordLists.getNounWords1().add((Kannzi) entity);
						break;
					case 1:
						entity = new Kannzi(outForStr[0], outForStr[1], outForStr[2]);
						wordLists.getNounWords2().add((Kannzi) entity);
						break;
					case 2:
						entity = new Kannzi(outForStr[0], outForStr[1], outForStr[2]);
						wordLists.getVerbWords().add((Kannzi) entity);
						break;
					case 3:
						entity = new Kannzi(outForStr[0], outForStr[1], outForStr[2]);
						wordLists.getIAdjectiveWords().add((Kannzi) entity);
						break;
					case 4:
						entity = new Kannzi(outForStr[0], outForStr[1], outForStr[2]);
						wordLists.getNaAdjectiveWords().add((Kannzi) entity);
						break;
					case 5:
						entity = new Kannzi(outForStr[0], outForStr[1], outForStr[2]);
						wordLists.getAdverbWrods().add((Kannzi) entity);
						break;
					case 6:
						entity = new Katakana(outForStr[0], outForStr[2]);
						wordLists.getKatakanaWords().add((Katakana) entity);
						break;
				};

	        }
			reader.close();
			inputStreamReader.close();
			file.getInputStream().close();
			
			return wordLists;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
        
	}

	public void makePdfFile(HttpServletResponse response, 
			JapanesWordLists words, FileInfo fileInfo) throws Exception {
		
		PdfHelper pdfHelper = new PdfHelper(fileInfo.getFileName());
		pdfHelper.setFileOutputStream(response);
//		pdfHelper.setFileOutputStream();
		pdfHelper.openDocument();
		pdfHelper.makeTestPage(words);
		pdfHelper.closeDocument();
		System.out.println("파일 생성 완료");
		
//		return response;
	}
	

}
