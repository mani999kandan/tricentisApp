package com.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.Purchase;
import com.pages.ShoppingCart;


public class ShoppingCartModule extends TestBase {

	@Test
	public void cartDetails() throws Exception
	{
		ShoppingCart SC= new ShoppingCart(driver);

		SC.totalPrice();
		SC.clickTermsCheckbox();
		SC.clickCheckoutBtn();
	}
}
