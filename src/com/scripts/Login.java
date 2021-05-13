package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginScreen;



public class Login extends TestBase {
	  
		String DocumentName ="InputData";
		String SheetName="LoginScreen";
		LoginScreen LS= new LoginScreen(driver);
		
	@Test
	public void PassCredentials() throws Exception // Giving the Login Credentials
	{
		LS.verifyLoginScreen();
	
		LS.enterEmail(Readexcel(DocumentName,SheetName, 2, 2));
		
		LS.enterPassword(Readexcel(DocumentName,SheetName, 3, 2));
		LS.clickLoginBtn();
		
		
	}
}
