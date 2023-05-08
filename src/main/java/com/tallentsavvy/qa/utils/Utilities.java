package com.tallentsavvy.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME=5;
	
	public static String generateEmailWithTimestamp() {
		 
		 Date  date = new Date();
		 String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		 return "amotoori"+timestamp+"@gmail.com";
		 
	 }
	
	public static Object[][] getTestDataFromExcel (String sheetName) {
		//Download poi, poi-ooxml, poi-ooxml-schemas these 3 packages with common version 4.2.1
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.xlsx");
		XSSFWorkbook workbook = null;	
		try {	
		FileInputStream fisexcel = new FileInputStream(excelFile);		
		 workbook = new XSSFWorkbook(fisexcel);
			}catch(Throwable e) {
				
				e.printStackTrace();
			}
			
			
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rows][cols];
		
		for (int i=0; i<rows; i++)
		{
			
			XSSFRow row = sheet.getRow(i+1);
			
			for (int j = 0; j<cols; j++) {
				
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch(celltype) {
				
				case STRING:
					data[i][j]= cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
					default:
						data[i][j]= cell.getStringCellValue();
					
				}
			}
		}
		return data;
	}

		
}
