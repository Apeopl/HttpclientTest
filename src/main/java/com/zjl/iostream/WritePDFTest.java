package com.zjl.iostream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class WritePDFTest {
	public static void main(String[] args) throws Exception {
		OutputStream out = new FileOutputStream(new File("C:/Users/king-zheng/Desktop/out.pdf"));
		Document doc = new Document();
		PdfWriter.getInstance(doc, out);
		doc.open();
		doc.add(new Paragraph("hello，PDF!"));
		doc.add(new Paragraph(new Date().toString()));
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(methodName);
		doc.close();
		out.close();
	}
}
