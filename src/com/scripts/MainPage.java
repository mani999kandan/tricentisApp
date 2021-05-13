package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.MainScreen;



public class MainPage extends TestBase {

	@Test
	public void Dashboard() throws Exception
	{
		MainScreen ms= new MainScreen(driver);
		ms.clickLoginLink();
	}
}
