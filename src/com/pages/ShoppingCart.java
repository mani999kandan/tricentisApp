package com.pages;

import java.math.BigInteger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.scripts.PurchaseModule;


public class ShoppingCart extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	public ShoppingCart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//span[@class='product-price']") WebElement subTotalPrice;
	@FindBy(xpath="//button[@type='submit']") WebElement checkout;
	@FindBy(xpath="(//input[@type='checkbox'])[2]") WebElement terms;
	@FindBy(xpath="//table[@class='cart-total']/tbody[1]/tr[1]/td[2]/span[1]/span[1]") WebElement subTotal;

	
	public void totalPrice()
	{
		String subTotalAmt= subTotal.getText();
	
		Float ExpectedTotalPrice=Float.parseFloat(subTotalAmt);
		Float ActualTotalPrice=PurchaseModule.Totalvalue;
		Assert.assertEquals(ActualTotalPrice, ExpectedTotalPrice);
		 test.log(LogStatus.PASS,"Verified sub total price and price order " + "Subtotal Price " +ExpectedTotalPrice + "Price (Quantity * Unit Price of the item)" +ActualTotalPrice);
			
		}
	public void clickCheckoutBtn() throws Exception
	{
		 wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
		 test.log(LogStatus.PASS,"Clicked on Checkout Button");
			 
	
		}
	public void clickTermsCheckbox() throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(terms)).click();
		 test.log(LogStatus.PASS,"Clicked on Terms Check Box");
		 test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));   
			
		}
}
