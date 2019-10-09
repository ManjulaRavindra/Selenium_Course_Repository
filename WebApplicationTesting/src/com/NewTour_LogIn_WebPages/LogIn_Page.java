/*This is called as Object Repository Class in POM which identifies the elements and business logics(Operations) 
related to that particular page.*/

package com.NewTour_LogIn_WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn_Page {
	
	//Identifying the Username and password elements on Login Page
	@FindBy(name="userName")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="login")
	WebElement Submit_Btn;
	
	public void LogIn(String userName,String password)
	{
		UserName.sendKeys(userName);
		Password.sendKeys(password);
		Submit_Btn.click();
	}
	
}
