package com.team3.miniproject.testcases.ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RegistrationData {

	public ArrayList<ArrayList<String>> userData() throws IOException{
		ArrayList<ArrayList<String>> userdata=new ArrayList<ArrayList<String>>(5);
		
		
		FileInputStream fis = new FileInputStream("Resources\\RegistrationData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		try {
		for(int i=0;i<5;i++) {
			userdata.add(new ArrayList());
			ArrayList<String> iuserdata=new ArrayList<String>(6);
			for(int j=0;j<6;j++) {
				if(sheet.getRow(i).getCell(j)==null) {
					iuserdata.add("");
				}else {
				iuserdata.add(sheet.getRow(i).getCell(j).toString());
				}
			}
			userdata.get(i).addAll(iuserdata);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return userdata;
	}
	
//	public static void main(String args[]) throws IOException {
//		RegistrationData rd=new RegistrationData();
//		ArrayList<ArrayList<String>> myData=rd.userData();
//		System.out.println(myData.get(0).get(0));
//	}
}
