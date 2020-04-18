package com.myproject.japanese;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

public class makePdfFileTest {
	
	private String fileName="1234.pdf";
	
	public InputStream makePdfFile() {
		InputStream resultIS=null;
		
		Document document = new Document(PageSize.A4);
		document.open();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		document.close();
		
		
		
		return resultIS;
	}

}
