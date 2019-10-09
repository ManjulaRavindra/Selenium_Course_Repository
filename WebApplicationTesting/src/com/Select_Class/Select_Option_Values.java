package com.Select_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Select_Option_Values {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgondyala\\workspace\\WebApplicationTesting\\DriverFiles\\chromedriver.exe");
		WebDriver driver=null;
		String url="http://newtours.demoaut.com/mercuryregister.php";
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement Country=driver.findElement(By.name("country"));
		Country.click();
		List<WebElement>CountryNames=Country.findElements(By.tagName("option"));
		int CountryCount=CountryNames.size();
		
		Select select_Country = new Select(Country);
		List<WebElement>CountryNameOptions=select_Country.getOptions();
		FileInputStream file = new FileInputStream(".//src//com//All_Excel_Sheets//Excel_CountryDetals.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
				
		for(int i=0;i<CountryCount;i++)
		{
			//Taking all the country names into a variable
			String CountryName=CountryNameOptions.get(i).getText();
			System.out.println(CountryName);
			
			//Sending the data into the row(index) of the cell(0)
			Row row=sheet.createRow(i);
			Cell cell=row.createCell(0);
			
			//Writing the data into each row of a cell
			cell.setCellValue(CountryName);
			
			//Saving the file.
			FileOutputStream file1=new FileOutputStream(".//src//com//All_Excel_Sheets/Excel_CountryDetals.xlsx");
			workbook.write(file1);
			
		}
		
		driver.quit();
	}

}
