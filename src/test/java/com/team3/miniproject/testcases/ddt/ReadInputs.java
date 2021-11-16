package com.team3.miniproject.testcases.ddt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.sun.rowset.internal.Row;

public class ReadInputs {
	
	String fileName;
	String sheetName;
	String filePath;
	String emailid;
	String password;
	public int i;
	public int rowCount;
	Sheet Sheet;
	Workbook Workbook;
    public static void main(String args[]) throws IOException{
       
    }

    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
    File file = new File(filePath+"\\"+fileName);
    FileInputStream inputStream = new FileInputStream(file);
    Workbook = new XSSFWorkbook(inputStream);
    Sheet = Workbook.getSheet(sheetName);
    rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
    
    }  
    public String getEmailId() {
    	Row row = Sheet.getRow(i);
    	return(row.getCell(0).getStringCellValue());
    }
    public String getPassword() {
    	Row row = Sheet.getRow(i);
    	return(row.getCell(1).getStringCellValue());
    }
}
