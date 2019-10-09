package com.NewTours_TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.NewTour_LogIn_WebPages.LogIn_Page;
import com.TestNG.BaseTest_NewTours;

public class NewTour_LogIn_Test extends BaseTest_NewTours{
	LogIn_Page login = null;
	@Test
	public void SignIn() throws IOException{
		FileInputStream file=new FileInputStream("./src/com/All_Excel_Sheets/NewTours_LogInTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			LogIn_Page login = new LogIn_Page();
			login = PageFactory.initElements(driver, LogIn_Page.class);
			login.LogIn(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
			System.out.println(i+"= Credentials entered");
		}
	}

}
