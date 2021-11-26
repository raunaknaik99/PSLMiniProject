package com.team3.miniproject.testcases.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppleCinemaData {
	ReadData reader=new ReadData();
	public ArrayList<ArrayList<String>> appleCinemaData() throws IOException {
		reader.iValue=8;
		reader.jValue=2;
		reader.iSize=1;
		reader.jSize=3;
		ArrayList<ArrayList<String>> cinemaData=reader.userData("src\\test\\resources", "loginDDT.xlsx","Apple Cinema");
		return(cinemaData);
//       ArrayList<ArrayList<String>> cinemaData = new ArrayList<ArrayList<String>>(4);
//		FileInputStream fis = new FileInputStream("src\\test\\resources\\AppleCinemaData.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheet("Apple Cinema");
//		try {
//			for (int i = 0; i < 8; i++) {
//				cinemaData.add(new ArrayList());
//				ArrayList<String> icinemadata = new ArrayList<String>(3);
//				for (int j = 0; j < 2; j++) {
//					if (sheet.getRow(i).getCell(j) == null) {
//						icinemadata.add("");
//					} else {
//						icinemadata.add(sheet.getRow(i).getCell(j).toString());
//					}
//				}
//				cinemaData.get(i).addAll(icinemadata);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return cinemaData;
	}
}
