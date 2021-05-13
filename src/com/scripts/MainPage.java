package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.MainScreen;



public class MainPage extends TestBase {

	MainScreen ms= new MainScreen(driver);
	
	@Test
	public void Dashboard() // Click on Login Link
	{
		ms.clickLoginLink();
	}
}
