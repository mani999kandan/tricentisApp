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
	CheckoutScreen CS= new CheckoutScreen(driver);
	
	@Test (priority=1) // Bill Address of the Order
	public void billAddressDetails() throws Exception
	{
		
		CS.selectAddress();
		CS.enterFirstName(Readexcel(DocumentName,SheetName, 2, 2));
		CS.enterLastName(Readexcel(DocumentName,SheetName, 3, 2));
		CS.selectCountry(Readexcel(DocumentName,SheetName, 4, 2));
		CS.enterCity(Readexcel(DocumentName,SheetName, 5, 2));
		CS.enterAddress1(Readexcel(DocumentName,SheetName, 6, 2));
		CS.enterZipCode(Readexcel(DocumentName,SheetName, 7, 2));
		CS.enterphoneNumber(Readexcel(DocumentName,SheetName, 8, 2));
		CS.clickContinebtn();
	}
	
	
	@Test (priority=2)// Shipping Address of the Order
	public void shippingAddress() throws Exception
	{
		
		CS.clickShippingAddress(Readexcel(DocumentName,SheetName, 2, 2),Readexcel(DocumentName,SheetName, 3, 2),Readexcel(DocumentName,SheetName, 6, 2),Readexcel(DocumentName,SheetName, 5, 2),Readexcel(DocumentName,SheetName, 7, 2),Readexcel(DocumentName,SheetName, 4, 2));
		CS.clickShippingAddressConti();
	}	
	
	
	@Test (priority=3)// Shipping Method
	public void shippingMethod() throws Exception
	{
		
		
		CS.clickShippingMethod();
		CS.clickShippingMethodConti();
	}	
	@Test (priority=4)// Payment Method
	public void paymentMethod() throws Exception
	{
		
		CS.clickPaymentMethod();
		CS.clickContinueButtonPaymentMethod();
	}	
	@Test (priority=5)// Payment Information
	public void paymentInformation() throws Exception
	{
		
		CS.verifyPaymentText();
		CS.clickContinueButtonPaymentInform();
	}
	@Test (priority=6)// Confirm Order
	public void confirmOrder() throws Exception
	{
		
		CS.clickConfirmOrderBtn();
		CS.verifyCheckOutText();
		CS.getOrderNumber();
		CS.clickContineSuccess();
		
	}
	
}
