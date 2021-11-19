package com.team3.miniproject.testcases.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginData {
	
	public ArrayList<ArrayList<String>> loginData() throws IOException {
		ArrayList<ArrayList<String>> logindata = new ArrayList<ArrayList<String>>(9);

		FileInputStream fis = new FileInputStream("src\\test\\resources\\loginDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		try {
			for (int i = 0; i < 9; i++) {
				logindata.add(new ArrayList());
				ArrayList<String> ilogindata = new ArrayList<String>(6);
				for (int j = 0; j < 3; j++) {
					if (sheet.getRow(i).getCell(j) == null) {
						ilogindata.add("");
					} else {
						ilogindata.add(sheet.getRow(i).getCell(j).toString());
					}
				}
				logindata.get(i).addAll(ilogindata);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return logindata;
	}

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		LoginData dt=new LoginData();
//		ArrayList<ArrayList<String>> myData=dt.loginData();
//		System.out.println(myData.get(6).get(0));
//
//	}

}
