package com.team3.miniproject.testcases.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppleCinemaData {
	public ArrayList<ArrayList<String>> appleCinemaData() throws IOException {
		ArrayList<ArrayList<String>> cinemaData = new ArrayList<ArrayList<String>>(1);

		FileInputStream fis = new FileInputStream("src\\test\\resources\\AppleCinemaData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Apple Cinema");
		try {
			for (int i = 0; i < 8; i++) {
				cinemaData.add(new ArrayList());
				ArrayList<String> icinemadata = new ArrayList<String>(3);
				for (int j = 0; j < 2; j++) {
					if (sheet.getRow(i).getCell(j) == null) {
						icinemadata.add("");
					} else {
						icinemadata.add(sheet.getRow(i).getCell(j).toString());
					}
				}
				cinemaData.get(i).addAll(icinemadata);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return cinemaData;
	}
}
