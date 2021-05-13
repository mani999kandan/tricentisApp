package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;



public class LoginScreen extends TestBase{
public LoginScreen(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}


@FindBy(xpath="//h1[text()='Welcome, Please Sign In!']") WebElement title;
@FindBy(id="Email") WebElement email;
@FindBy(id="Password") WebElement password;
@FindBy(xpath="//input[@value='Log in']") WebElement loginBtn;
@FindBy(xpath="//a[normalize-space()='testdemowebshop@gmail.com']") WebElement accountID;


public void verifyLoginScreen()
{
	String expectedMessage = "Welcome, Please Sign In!";
	String Header = title.getText();
	Assert.assertEquals(Header, expectedMessage);
	test.log(LogStatus.PASS,"Verified welcome message: "+expectedMessage);
	
}

public void enterEmail(String emailAddress)
{
	email.sendKeys(emailAddress);
	test.log(LogStatus.PASS,"Entered Email Address: "+emailAddress);

	}

public void enterPassword(String passwordValue)
{
	password.sendKeys(passwordValue);
	test.log(LogStatus.PASS,"Entered Password Address: "+passwordValue);

}
public void clickLoginBtn()
{
	loginBtn.click();
	test.log(LogStatus.PASS,"Clicked on Login Button ");
	test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));   

}


public void verifyAccountID(String emailAddress) throws InterruptedException
{
	
	
	String Header = accountID.getText();
	Assert.assertEquals(Header, emailAddress);
	}
}
