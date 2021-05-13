package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginScreen;



public class Login extends TestBase {
	  
		String DocumentName ="InputData";
		String SheetName="LoginScreen";
	@Test
	public void PassCrendentials() throws Exception
	{
		LoginScreen LS= new LoginScreen(driver);
		LS.verifyLoginScreen();
	
		LS.enterEmail(Readexcel(DocumentName,SheetName, 2, 2));
		
		LS.enterPassword(Readexcel(DocumentName,SheetName, 3, 2));
		LS.clickLoginBtn();
		
		LS.verifyAccountID(Readexcel(DocumentName,SheetName, 2, 2));
	}
}
