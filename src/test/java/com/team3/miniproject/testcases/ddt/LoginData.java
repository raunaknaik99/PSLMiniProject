package com.team3.miniproject.testcases.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginData {

	public ArrayList<ArrayList<String>> loginData() throws IOException {
		ArrayList<ArrayList<String>> userdata = new ArrayList<ArrayList<String>>(10);

		FileInputStream fis = new FileInputStream("src\\test\\resources\\RegistrationData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Login");
		try {
			for (int i = 0; i < 10; i++) {
				userdata.add(new ArrayList());
				Row row=sheet.getRow(i);
				ArrayList<String> iuserdata = new ArrayList<String>(2);
				if(row==null) {
					iuserdata.add("");
					iuserdata.add("");
					userdata.get(i).addAll(iuserdata);
				}else {
				for (int j = 0; j < 2; j++) {
					if (sheet.getRow(i).getCell(j) == null) {
						iuserdata.add("");
					} else {
						iuserdata.add(sheet.getRow(i).getCell(j).toString());
					}
				}
				userdata.get(i).addAll(iuserdata);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return userdata;
	}
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		LoginData dt=new LoginData();
//		ArrayList<ArrayList<String>> myData=dt.loginData();
//		System.out.println(myData.get(8).get(0));
//
//	}

}
