package com.team3.miniproject.testcases.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SearchData {
	ReadData reader=new ReadData();
	public ArrayList<ArrayList<String>> userData() throws IOException {
		reader.iValue=6;
		reader.jValue=4;
		reader.iSize=12;
		reader.jSize=6;
		ArrayList<ArrayList<String>> useData=reader.userData("src\\test\\resources", "loginDDT.xlsx","Search");
		return(useData);
//		ArrayList<ArrayList<String>> userdata = new ArrayList<ArrayList<String>>(12);
//
//		FileInputStream fis = new FileInputStream("src\\test\\resources\\loginDDT.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheet("Search");
//		try {
//			for (int i = 0; i < 6; i++) {
//				userdata.add(new ArrayList());
//				ArrayList<String> iuserdata = new ArrayList<String>(6);
//				for (int j = 0; j < 4; j++) {
//					if (sheet.getRow(i).getCell(j) == null) {
//						iuserdata.add("");
//					} else {
//						iuserdata.add(sheet.getRow(i).getCell(j).toString());
//					}
//				}
//				userdata.get(i).addAll(iuserdata);
//			}
//			workbook.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return userdata;
	}

	public static void main(String args[]) throws IOException {
		SearchData rd = new SearchData();
		ArrayList<ArrayList<String>> myData = rd.userData();
		System.out.println(myData);
	}
}