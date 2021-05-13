package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CheckoutScreen;
import com.pages.Purchase;
import com.pages.ShoppingCart;


public class CheckoutModule extends TestBase {
	String DocumentName ="InputData";
	String SheetName="CheckOut";
	@Test (priority=1)
	public void billAddressDetails() throws Exception
	{
		CheckoutScreen CS= new CheckoutScreen(driver);

		CS.selectAddress();
		CS.enterFirstName(Readexcel(DocumentName,SheetName, 2, 2));
		CS.enterLastName(Readexcel(DocumentName,SheetName, 3, 2));
		CS.selectCountry(Readexcel(DocumentName,SheetName, 4, 2));
		CS.enterCity(Readexcel(DocumentName,SheetName, 5, 2));
		CS.enterAddress1(Readexcel(DocumentName,SheetName, 6, 2));
		CS.enterZipCode(Readexcel(DocumentName,SheetName, 7, 2));
		
		String s=Readexcel(DocumentName,SheetName, 8, 2);
	System.out.println(s);
		CS.enterphoneNumber(s);
		CS.clickContinebtn();
	}
	@Test (priority=2)
	public void shippingAddress() throws Exception
	{
		CheckoutScreen CS= new CheckoutScreen(driver);
		
		CS.clickShippingAddress(Readexcel(DocumentName,SheetName, 2, 2),Readexcel(DocumentName,SheetName, 3, 2),Readexcel(DocumentName,SheetName, 6, 2),Readexcel(DocumentName,SheetName, 5, 2),Readexcel(DocumentName,SheetName, 7, 2),Readexcel(DocumentName,SheetName, 4, 2));
		CS.clickShippingAddressConti();
	}	
	@Test (priority=3)
	public void shippingMethod() throws Exception
	{
		CheckoutScreen CS= new CheckoutScreen(driver);
		
		CS.clickShippingMethod();
		CS.clickShippingMethodConti();
	}	
	@Test (priority=4)
	public void paymentMethod() throws Exception
	{
		CheckoutScreen CS= new CheckoutScreen(driver);
		
		CS.clickPaymentMethod();
		CS.clickContinueButtonPaymentMethod();
	}	
	@Test (priority=5)
	public void paymentInformation() throws Exception
	{
		CheckoutScreen CS= new CheckoutScreen(driver);
		
		CS.verifyPaymentText();
		CS.clickContinueButtonPaymentInform();
	}
	@Test (priority=6)
	public void confirmOrder() throws Exception
	{
		CheckoutScreen CS= new CheckoutScreen(driver);
		
		CS.clickConfirmOrderBtn();
		CS.verifyCheckOutText();
		CS.getOrderNumber();
		CS.clickContineSuccess();
		
	}
	
}
