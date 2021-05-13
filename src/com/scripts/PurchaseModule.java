package com.scripts;

import java.math.BigInteger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.Purchase;


public class PurchaseModule extends TestBase {


public static Float Totalvalue;

	@Test
	public void OrderBook() throws Exception //Booking the orders
	{
		String DocumentName ="InputData";
		String SheetName="PurchaseModule";
		String SheetName1="LoginScreen";
	
	
		Purchase pm= new Purchase(driver);
		
		pm.verifyAccountID(Readexcel(DocumentName,SheetName1, 2, 2));
		
		pm.clickCartLink();
		if (pm.verifyCartStatus()!=0)
		{
			System.out.println("No items in the cart");
		
		}
			else
		{
		pm.clickRemoveCartCheck();
		pm.clickUpdateCartBtn();
		}
		pm.clickBooksCategory();
		pm.selectBook();
		String Quantity =Readexcel(DocumentName,SheetName, 2, 2);
		pm.enterQuantity(Quantity);
		
		String pricevalue =pm.getPriceDetails();
		System.out.println(pricevalue);

		Totalvalue = Float.parseFloat(pricevalue) * Float.parseFloat(Quantity);
		System.out.println("Subtotal:" +Totalvalue);

		pm.clickCartBtn();
		pm.verifyCartMessage();
		pm.clickCartLink();
	}
}
