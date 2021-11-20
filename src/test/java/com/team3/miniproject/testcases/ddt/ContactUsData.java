package com.team3.miniproject.testcases.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ContactUsData {

	public ArrayList<ArrayList<String>> contactUsData() throws IOException {
		ArrayList<ArrayList<String>> contactData = new ArrayList<ArrayList<String>>(4);

		FileInputStream fis = new FileInputStream("src\\test\\resources\\loginDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Contact");
		try {
			for (int i = 0; i < 4; i++) {
				contactData.add(new ArrayList());
				ArrayList<String> icontactdata = new ArrayList<String>(3);
				for (int j = 0; j < 3; j++) {
					if (sheet.getRow(i).getCell(j) == null) {
						icontactdata.add("");
					} else {
						icontactdata.add(sheet.getRow(i).getCell(j).toString());
					}
				}
				contactData.get(i).addAll(icontactdata);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return contactData;
	}

//	public static void main(String args[]) throws IOException {
//	ContactUsData rd=new ContactUsData();
//	ArrayList<ArrayList<String>> myData=rd.contactUsData();
//	System.out.println(myData);
//}
}
