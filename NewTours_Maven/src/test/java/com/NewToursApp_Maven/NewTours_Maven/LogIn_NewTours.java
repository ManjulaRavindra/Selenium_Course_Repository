package com.NewToursApp_Maven.NewTours_Maven;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

public class LogIn_NewTours extends BaseTest {
	@Test
	public void LogInTest() throws IOException, InterruptedException
	{
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.linkText("REGISTER")).click();
		
		FileInputStream file = new FileInputStream("./ExcelSheets/NewUserRegistrationTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		
		int rowCount = sheet.getLastRowNum();
		for(int j=1;j<=rowCount;j++)
		{
			System.out.println("j value = "+j);
			Row row =sheet.getRow(j);
			int cellCount=row.getLastCellNum();

			//System.out.println("Total Cells present in the sheet : "+ cellCount);
			
			
			for(int i=0;i<cellCount-1;)
			{
				
				WebElement firstName = driver.findElement(By.name("firstName"));
				firstName.clear();
				firstName.sendKeys(row.getCell(i).getStringCellValue());
				System.out.println(i+" = "+row.getCell(i).getStringCellValue());
				
				WebElement lastName = driver.findElement(By.name("lastName"));
				lastName.clear();
				lastName.sendKeys(row.getCell(++i).getStringCellValue());
				System.out.println(i+" = "+row.getCell(i).getStringCellValue());
					
				double d=row.getCell(++i).getNumericCellValue();
				long l=(long)d ;
				String phoneNumber= Long.toString(l);
				System.out.println(i+" phoneNumber="+phoneNumber);
							
				WebElement Phone = driver.findElement(By.name("phone"));
				Phone.clear();
				Phone.sendKeys(phoneNumber);
					
					WebElement Email = driver.findElement(By.name("userName"));
					Email.clear();
					Email.sendKeys(row.getCell(++i).getStringCellValue());
					System.out.println(i+" = "+row.getCell(i).getStringCellValue());
					
					WebElement Address1 = driver.findElement(By.name("address1"));
					Address1.clear();
					Address1.sendKeys(row.getCell(++i).getStringCellValue());
					System.out.println(i+" = "+row.getCell(i).getStringCellValue());
					
					WebElement City = driver.findElement(By.name("city"));
					City.clear();
					City.sendKeys(row.getCell(++i).getStringCellValue());
					System.out.println(i+" = "+row.getCell(i).getStringCellValue());
					
					WebElement State = driver.findElement(By.name("state"));
					State.clear();
					State.sendKeys(row.getCell(++i).getStringCellValue());
					System.out.println(i+" = "+row.getCell(i).getStringCellValue());
					
					//Type casting for double from Numeric to String
					
					double d1 = row.getCell(++i).getNumericCellValue();
					long l1=(long)d1;
					String postal=Long.toString(l1);
					WebElement PostalCode = driver.findElement(By.name("postalCode"));
					PostalCode.clear();
					PostalCode.sendKeys(postal);
					System.out.println(i+" = "+postal);
					
					WebElement Country = driver.findElement(By.name("country"));
					Country.sendKeys(row.getCell(++i).getStringCellValue());
					System.out.println(i+" = "+row.getCell(i).getStringCellValue());
					
					WebElement UserName = driver.findElement(By.name("email"));
					UserName.clear();
					String expected_UserName = row.getCell(++i).getStringCellValue();
					UserName.sendKeys(expected_UserName);
					System.out.println(i+" = "+row.getCell(i).getStringCellValue());
					
					WebElement Password = driver.findElement(By.name("password"));
					Password.clear();
					Password.sendKeys(row.getCell(++i).getStringCellValue());
					System.out.println(i+" = "+row.getCell(i).getStringCellValue());
					
					WebElement ConfirmPassword = driver.findElement(By.name("confirmPassword"));
					ConfirmPassword.clear();
					ConfirmPassword.sendKeys(row.getCell(++i).getStringCellValue());
					System.out.println(i+" = "+row.getCell(i).getStringCellValue());
					
					WebElement SumitButtom = driver.findElement(By.name("register"));
					SumitButtom.click();
					System.out.println("NOW the i value is :"+i);
					
					//Validation after submit
					
					String actual_UserName=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
					System.out.println("actual Username="+actual_UserName+"and expected Username="+expected_UserName);
					
					if(actual_UserName.contains(expected_UserName)){
						System.out.println("User Registration Success -- PASS");
						row.createCell(cellCount).setCellValue("User Registration Success -- PASS");
						FileOutputStream file1=new FileOutputStream("./ExcelSheets/NewUserRegistrationTestResults.xlsx");
						workBook.write(file1);
					}
					else{
						System.out.println("User Registration Failed -- FAIL");
						row.createCell(cellCount).setCellValue("User Registration Failed -- FAIL");
						FileOutputStream file1=new FileOutputStream("./ExcelSheets/NewUserRegistrationTestResults.xlsx");
						workBook.write(file1);
					
					}
					
			}
			driver.navigate().back();
		}

		
	}

}
