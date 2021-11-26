package com.team3.miniproject.testcases.ddt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	public int i;
	public int rowCount;
	Sheet Sheet;
	Workbook Workbook;
	String cellData;
	public int iValue;
	public int jValue;
	public int iSize;
	public int jSize;
	public ArrayList<ArrayList<String>> userData(String filePath,String fileName,String sheetName) throws IOException {
		ArrayList<ArrayList<String>> userdata = new ArrayList<ArrayList<String>>(iSize);
		File file = new File(filePath+"\\"+fileName);
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook = new XSSFWorkbook(inputStream);
	    Sheet = Workbook.getSheet(sheetName);
	    rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
	try {
		for (int i = 0; i < iValue; i++) {
			userdata.add(new ArrayList());
			ArrayList<String> iuserdata = new ArrayList<String>(jSize);
			for (int j = 0; j < jValue; j++) {
				if (Sheet.getRow(i).getCell(j) == null) {
					iuserdata.add("");
				} else {
					iuserdata.add(Sheet.getRow(i).getCell(j).toString());
				}
			}
			userdata.get(i).addAll(iuserdata);
		}
		Workbook.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	return userdata;
}
}
