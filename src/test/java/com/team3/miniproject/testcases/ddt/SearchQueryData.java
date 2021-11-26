package com.team3.miniproject.testcases.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SearchQueryData {
	ReadData reader=new ReadData();
	public ArrayList<ArrayList<String>> searchBarData() throws IOException {
		reader.iValue=2;
		reader.jValue=1;
		reader.iSize=10;
		reader.jSize=3;
		ArrayList<ArrayList<String>> searchData=reader.userData("src\\test\\resources", "loginDDT.xlsx","search queries");
		return(searchData);
//		ArrayList<ArrayList<String>> searchData = new ArrayList<ArrayList<String>>(10);
//
//		FileInputStream fis = new FileInputStream("src\\test\\resources\\loginDDT.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheet("search queries");
//		try {
//			for (int i = 0; i < 2; i++) {
//				searchData.add(new ArrayList());
//				ArrayList<String> isearchdata = new ArrayList<String>(3);
//				for (int j = 0; j < 1; j++) {
//					if (sheet.getRow(i).getCell(j) == null) {
//						isearchdata.add("");
//					} else {
//						isearchdata.add(sheet.getRow(i).getCell(j).toString());
//					}
//				}
//				searchData.get(i).addAll(isearchdata);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return searchData;
	}
}
