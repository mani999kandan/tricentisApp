package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;



public class MainScreen extends TestBase {
	public MainScreen(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(linkText="Log in") WebElement logIn;
	//----- Log out
	@FindBy(linkText="Log out") WebElement logOut;
	
	public void clickLoginLink() throws Exception
	{
		logIn.click();

 		test.log(LogStatus.PASS,"Clicked on Login Link ");
		test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));   
		}
	public void clickLogLink() throws Exception
	{
		logOut.click();
		test.log(LogStatus.PASS,"Clicked on LogOut Link ");
		test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));   
		
		}
}
