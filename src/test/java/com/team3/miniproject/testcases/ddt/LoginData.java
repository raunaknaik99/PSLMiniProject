package com.team3.miniproject.testcases.ddt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class LoginData {
    Workbook Workbook;
    Sheet Sheet;
    int rowCount;
	ReadData reader=new ReadData();
	public ArrayList<ArrayList<String>> loginData() throws IOException {
		reader.iValue=10;
		reader.jValue=2;
		reader.iSize=10;
		reader.jSize=2;
		ArrayList<ArrayList<String>> useData=reader.userData("src\\test\\resources", "loginDDT.xlsx","Login");
		return(useData);
	}
		//ArrayList<ArrayList<String>> userdata = new ArrayList<ArrayList<String>>(10);
//			
//		FileInputStream fis = new FileInputStream("src\\test\\resources\\loginDDT.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheet("Login");
//		try {
//			for (int i = 0; i < 10; i++) {
//				userdata.add(new ArrayList());
//				Row row=sheet.getRow(i);
//				ArrayList<String> iuserdata = new ArrayList<String>(2);
//				if(row==null) {
//					iuserdata.add("");
//					iuserdata.add("");
//					userdata.get(i).addAll(iuserdata);
//				}else {
//				for (int j = 0; j < 2; j++) {
//					if (sheet.getRow(i).getCell(j) == null) {
//						iuserdata.add("");
//					} else {
//						iuserdata.add(sheet.getRow(i).getCell(j).toString());
//					}
//				}
//				userdata.get(i).addAll(iuserdata);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return userdata;
//	}

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		LoginData dt=new LoginData();
//		ArrayList<ArrayList<String>> myData=dt.loginData();
//		System.out.println(myData);
//
//	}

}
