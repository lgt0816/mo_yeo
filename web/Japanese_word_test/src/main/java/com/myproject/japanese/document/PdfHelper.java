package com.myproject.japanese.document;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.myproject.japanese.domain.JapanesWordLists;
import com.myproject.japanese.domain.Kannzi;
import com.myproject.japanese.domain.Katakana;
import com.myproject.japanese.domain.Word;
import com.myproject.japanese.domain.WordTypes;

import lombok.Getter;
import lombok.Setter;

public class PdfHelper implements WordTypes{
	static final String TAIL_FILE_NAME=".pdf";
	
	
	@Getter	@Setter private Document document;
	private BaseFont KoreanBaseFont;
	private BaseFont JapaneseBaseFont;
	private String fileName;
	private Font koreanFont;
	private Font JapaneseFont;
	

	//생성자
	public PdfHelper(String fileName) throws DocumentException, IOException {
		document = new Document();
		this.fileName = fileName;
		KoreanBaseFont = BaseFont.createFont("HYGoThic-Medium","UniKS-UCS2-H",BaseFont.EMBEDDED);
		JapaneseBaseFont = BaseFont.createFont("KozMinPro-Regular", "UniJIS-UCS2-H", BaseFont.NOT_EMBEDDED);
	}
	
	public void setFont(int textPoint) {
		this.koreanFont= new Font(KoreanBaseFont, textPoint,Font.NORMAL);
		this.JapaneseFont = new Font(JapaneseBaseFont, textPoint, Font.NORMAL);
	}
	
	public Font getFont() {
		return koreanFont;
	}


	//다운로드를 하기위한 OutputStream설정 
	public void setFileOutputStream(HttpServletResponse response) throws DocumentException, IOException {
		PdfWriter.getInstance(document, response.getOutputStream());
	}
	
	public void setFileOutputStream() throws FileNotFoundException, DocumentException {
		PdfWriter.getInstance(document, new FileOutputStream("D:\\pdf\\"+fileName+TAIL_FILE_NAME));
	}
	
	public void addTable(PdfPTable table) throws DocumentException {
		document.add(table);
	}
	
	public void openDocument() {
		document.open();
	}
	public void closeDocument() {
		document.close();
	}
	
	
	public void makeTestPage(JapanesWordLists lists) throws Exception{
//		setFileOutputStream();
//		document.open();
		
		
		setFont(12);
		List<Kannzi> list =null;
		List<Katakana> list2=null;
	
		for(int outCount=0;outCount<wordTypes.length;outCount++) {
			PdfPTable testTable = new PdfPTable(6);	//col 갯수 6개짜리 테이블 생성
			String temp1="";	//inner for문에서 사용
			String temp2="";	//inner for문에서 사용

			//리스트 선택
			switch(outCount) {
				case 0: 
					list=lists.getNounWords1();
					break;
				case 1:
					list=lists.getNounWords2();
					break;
				case 2:
					list = lists.getVerbWords();
					break;
				case 3:
					list = lists.getIAdjectiveWords();
					break;
				case 4:
					list = lists.getNaAdjectiveWords();
					break;
				case 5:
					list = lists.getAdverbWrods();
					break;
				case 6:
					list2 = lists.getKatakanaWords();
					break;
			}
			//문단 나누기
			Chunk chunk = new Chunk(wordTypes[outCount], koreanFont);	//글자 생성
			Paragraph ph = new Paragraph(chunk);	//단어의 종류를 문단으로 표시
			document.add(ph);
			
			
			//표 헤더 만들기
			for(int inCount=0;inCount<3;inCount++) {
				PdfPCell cellKannzi = new PdfPCell(new Paragraph(new Chunk("단어",koreanFont)));	//셀 생성 및 폰트 설정
				cellKannzi.setHorizontalAlignment(Element.ALIGN_CENTER);	//가운데 정렬
				cellKannzi.setRowspan(2);	//row 2개 크기
				cellKannzi.setBackgroundColor(BaseColor.GRAY);	//백그라운드색 설정
				testTable.addCell(cellKannzi);
				
				PdfPCell cellHurigana = new PdfPCell(new Paragraph("후리가나",koreanFont));
				cellHurigana.setHorizontalAlignment(Element.ALIGN_CENTER);	//가운데 정렬
				cellHurigana.setBackgroundColor(BaseColor.GRAY);
				testTable.addCell(cellHurigana);
			}
			for(int inCount=0;inCount<3;inCount++) {
				PdfPCell cellMeaning = new PdfPCell(new Paragraph("뜻",koreanFont));
				cellMeaning.setHorizontalAlignment(Element.ALIGN_CENTER);	//가운데 정렬
				cellMeaning.setBackgroundColor(BaseColor.GRAY);
				testTable.addCell(cellMeaning);
			}
//			
//			//표 내용 만들기
			if(outCount<wordTypes.length-1) {	//카타카나 이외의 단어를 보여줄 경우
				for(int inCount=0;inCount<list.size();inCount++) {
					PdfPCell cellKannzi = new PdfPCell(new Paragraph(list.get(inCount).getKannzi(),JapaneseFont));	//셀 생성 및 폰트 설정
					cellKannzi.setHorizontalAlignment(Element.ALIGN_CENTER);	//가운데 정렬
					cellKannzi.setRowspan(2);	//row 2개 크기
					PdfPCell cellHurigana = new PdfPCell(new Paragraph(list.get(inCount).getHurigana(),JapaneseFont));
					cellHurigana.setHorizontalAlignment(Element.ALIGN_CENTER);	//가운데 정렬
					
					testTable.addCell(cellKannzi);
					testTable.addCell(cellHurigana);
					
					if(inCount%3==0) {	//1번째 단어인경우 뜻을 temp1에 저장
						temp1 = list.get(inCount).getMeaning();
					}else if(inCount%3==1) {	//2번째 단어인경우 뜻을 temp2에 저장
						temp2 = list.get(inCount).getMeaning();
					}else if(inCount%3==2) {	//3번째 단어인 경우 앞에서 저장한 뜻과 현재 단어의 뜻을 셀로 만들어 테이블에 추가
						PdfPCell cellMeaning1 = new PdfPCell(new Paragraph(temp1,koreanFont));
						PdfPCell cellMeaning2 = new PdfPCell(new Paragraph(temp2,koreanFont));
						PdfPCell cellMeaning3 = new PdfPCell(new Paragraph(list.get(inCount).getMeaning(),koreanFont));
						
						testTable.addCell(cellMeaning1);
						testTable.addCell(cellMeaning2);
						testTable.addCell(cellMeaning3);
					}
				}
				
			}else {	//카타카나 단어를 보여줄 경우
				for(int inCount=0; inCount<list2.size();inCount++) {
					PdfPCell cellMeaning = new PdfPCell(new Paragraph(list2.get(inCount).getMeaning(),koreanFont));
					cellMeaning.setHorizontalAlignment(Element.ALIGN_CENTER);	//가운데 정렬
					PdfPCell cellKatakana = new PdfPCell(new Paragraph(list2.get(inCount).getKatakana(),JapaneseFont));
					cellMeaning.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					testTable.addCell(cellMeaning);
					testTable.addCell(cellKatakana);
				}
			}
			

			testTable.completeRow();	//현재 행이 지정한 열 개수만큼 셀이 생성되어 있지 않다면 기본 셀을 가지고 완성시킨다.
			document.add(testTable);
		}
//		document.close();
		
	}
	

}
