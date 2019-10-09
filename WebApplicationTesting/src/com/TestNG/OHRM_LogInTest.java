package com.TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OHRM_LogInTest extends BaseTest_OHRM_App {

	@Test
	public void LogIn() throws IOException{
		String expected_UserName="Admin";
	    String actual_User;
	    String expectedWebPageTitle = "OrangeHRM";
	    
	    FileInputStream file = new FileInputStream("./src/com/All_Excel_Sheets/OrangeHRM_LogIn_TestData.xlsx");
	    XSSFWorkbook workBook=new XSSFWorkbook(file);
	    XSSFSheet sheet= workBook.getSheet("Sheet1");
	    int rowCount = sheet.getLastRowNum();
	    System.out.println("rowCount ="+rowCount);
	    for(int i=1;i<=rowCount;i++)
	    {
	    	Row row = sheet.getRow(i);
	    	System.out.println("*******************Row value = "+i);
	    	WebElement userName=driver.findElement(By.id("txtUsername"));
	    	String UserName = row.getCell(0).getStringCellValue();
	    	System.out.println("UserName = "+UserName);
	    	userName.clear();
	    	userName.sendKeys(UserName);
	    	WebElement password = driver.findElement(By.id("txtPassword"));
	    	String Password = row.getCell(1).getStringCellValue();
	    	System.out.println("Password = "+Password);
	    	password.clear();
	    	password.sendKeys(Password);
	    	WebElement LogIn=driver.findElement(By.name("Submit"));
	    	LogIn.submit();
	    		    	
	    	 //Validating the login with valid credentials 
	        if (UserName.equalsIgnoreCase("admin") && Password.equalsIgnoreCase("admin123")) {

		    	actual_User=driver.findElement(By.partialLinkText("Admin")).getText();
		    	System.out.println("Actual User Name = "+actual_User);
		    	System.out.println("Expected User Name = "+expected_UserName);
		    	String actualWebPageTitle=driver.getTitle();
		    	System.out.println("actualWebPageTitle = "+actualWebPageTitle);
		    	if(actual_User.contains(expected_UserName)&actualWebPageTitle.equals(expectedWebPageTitle))
		    	{
		    		Cell cell=row.createCell(2);
		    		cell.setCellValue("Valid User -- PASS");
		    		FileOutputStream file1=new FileOutputStream("./src/com/All_Excel_Sheets/OrangeHRM_LogIn_TestResults.xlsx");
		    		workBook.write(file1);
		    		
		    	}
	        }
	    	else
	    	{
	    		Cell cell=row.createCell(2);
	    		cell.setCellValue("InValid User -- FAIL");
	    		FileOutputStream file1=new FileOutputStream("./src/com/All_Excel_Sheets/OrangeHRM_LogIn_TestResults.xlsx");
	    		workBook.write(file1);	    		
	    	}
	    	
	    	driver.navigate().back();
	    }
	}
    
    
    
	/*actual_Login_Page=driver.findElement(By.id("logInPanelHeading")).getText();
	System.out.println("*****************"+actual_Login_Page+"*****************");
	
	//Validating the Login Page when the OrangeHRM url is entered in the browser window
	actual_Login_Page=actual_Login_Page.substring(0, 5);
	
	System.out.println("*****************"+actual_Login_Page+"*****************");
	
	if(expected_LoginIn_Page.equalsIgnoreCase(actual_Login_Page)){
		
		System.out.println("Login page is opened");
		
	}
	else {
		System.out.println("Please enter a valid URL of OrangeHRM");
	}
	
    driver.findElement(By.id("txtUsername")).sendKeys(userName);
    driver.findElement(By.id("txtPassword")).sendKeys(passWord);
    driver.findElement(By.id("btnLogin")).click();

    String actualUser = driver.findElement(By.partialLinkText("Admin")).getText();
    System.out.println("The actual user of the orangehrm home page is : " + actualUser);
    String actualWebPageTitle=driver.getTitle();
    
               //Validating home page application and automating "Welcome Admin" after successful login
        if (actualUser.contains(userName)&actualWebPageTitle.equals(expectedWebPageTitle)) {
        	 System.out.println("OrangeHRM Home page is opened successfully");
        }
        else {
        	System.out.println("Login failed - Please entert the valid credentials");
        }*/

}