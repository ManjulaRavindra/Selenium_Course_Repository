package com.MouseOper;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
public class Amazon_HelloSignIn_YourOrders_Click {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgondyala\\workspace\\Mouse_Or_Keyboard_Operations\\DriverFiles\\chromedriver.exe");
		WebDriver driver=null;
		String url="http://amazon.in";
		driver=new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
				
	}

}
