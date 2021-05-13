package com.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class CheckoutScreen extends TestBase {
	public CheckoutScreen(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	WebDriverWait wait = new WebDriverWait(driver, 30);
@FindBy(id="billing-address-select") WebElement address;
@FindBy(id="BillingNewAddress_FirstName") WebElement firstName;
@FindBy(id="BillingNewAddress_LastName") WebElement lastName;
@FindBy(id="BillingNewAddress_Email") WebElement mailAddress;
@FindBy(id="BillingNewAddress_CountryId") WebElement country;
@FindBy(id="BillingNewAddress_City") WebElement city;
@FindBy(id="BillingNewAddress_Address1") WebElement address1;
@FindBy(xpath="//label[text()='Zip / postal code:']/following-sibling::input") WebElement code;
@FindBy(id="BillingNewAddress_PhoneNumber") WebElement phoneNumber;

@FindBy(xpath="//input[@value='Continue']") WebElement continuebtn;
//------------- Shipping Address Section
@FindBy(id="shipping-address-select") WebElement sameShippingAddress;

@FindBy(xpath="//div[@id='shipping-buttons-container']//input[1]") WebElement continueBtnShip;
//------------- Shipping Method Section
@FindBy(xpath="(//div[@class='method-name']//input)[2]") WebElement shippingMethod;
@FindBy(xpath="//div[@id='shipping-method-buttons-container']//input[1]") WebElement continueBtnShipMeth;

//------------- Shipping Payment Section
@FindBy(xpath="//div[@class='payment-details']//input") WebElement paymentMethod;
@FindBy(xpath="//div[@id='payment-method-buttons-container']//input[1]") WebElement continueBtnPayMeth;

//-------------- Payment Information
@FindBy(xpath="//div[@class='info']//table/tbody[1]/tr[1]/td[1]/p[1]") WebElement paymentText;
@FindBy(xpath="//div[@id='payment-info-buttons-container']//input[1]") WebElement continueBtnPayInfor;

//--------------- Confirm Order
@FindBy(xpath="//input[@value='Confirm']") WebElement confirmOrderBtn;

//----- Success Message Screen
@FindBy(xpath="//div[@class='title']//strong[1]") WebElement successMessage;
@FindBy(xpath="//ul[@class='details']//li[1]") WebElement orderNumber;
@FindBy(xpath="//input[@value='Continue']") WebElement contineSuccess;




public void selectAddress() throws Exception
{
	Select s= new Select(address);
	s.selectByVisibleText("New Address");
	test.log(LogStatus.PASS,"New Address Field selected New Address ");
	}

public void enterFirstName(String FName)
{
	firstName.clear();
	firstName.sendKeys(FName);
	test.log(LogStatus.PASS,"Entered First Name: "+FName);
		
}
public void enterLastName(String LName)
{
	lastName.clear();
	lastName.sendKeys(LName);
	test.log(LogStatus.PASS,"Entered Last Name: "+lastName);
		
}
public void enterMailAddress()
{
	mailAddress.clear();
	mailAddress.sendKeys("test@gmail.com");
	test.log(LogStatus.PASS,"Entered Mail Address: "+mailAddress);
		
}
public void selectCountry(String Country)
{

	Select s = new Select(country);
	s.selectByVisibleText(Country);
	test.log(LogStatus.PASS,"Selected Country: "+Country);

}
public void enterCity(String City)
{
	city.clear();
	city.sendKeys(City);
	test.log(LogStatus.PASS,"Entered City "+City);

	}

public void enterAddress1(String Address1)
{
	address1.clear();
	address1.sendKeys(Address1);
	test.log(LogStatus.PASS,"Entered Address1 "+Address1);
	}
public void enterZipCode(String pincode) throws InterruptedException
{
	code.sendKeys(pincode);	
	test.log(LogStatus.PASS,"Entered pincode "+pincode);
	
}
public void enterphoneNumber(String string)
{

	phoneNumber.sendKeys(string);
	test.log(LogStatus.PASS,"Entered phone number "+phoneNumber);
	
	}
public void clickContinebtn()
{
	test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));  
	continuebtn.click();
	test.log(LogStatus.PASS,"Clicked on Continue Button of Billing Address ");
	
	}
//Shipping Address Section
public void clickShippingAddress(String FN,String LN,String Add,String City,String Pincode,String Country) throws InterruptedException
{
	String space=" ";
	String comma=",";
	String ShippingAddress=FN+space+LN+comma+Add+comma+City+space+Pincode+comma+Country;
	Thread.sleep(3000);
	System.out.println(ShippingAddress);
	Select s = new Select(sameShippingAddress);
	 List<WebElement> lst = s.getOptions();
	  for(WebElement options: lst)
      {
          
      if(options.getText().equalsIgnoreCase(ShippingAddress))
      {
    	  options.click();
        break;
      }
      }
	   
		test.log(LogStatus.PASS,"Shipping Address is selected as same as Billing address" +ShippingAddress);
	
	}

public void clickShippingAddressConti() throws InterruptedException
{
	test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver))); 
	continueBtnShip.click();
	test.log(LogStatus.PASS,"Clicked on Continue Button of Shipping Address ");

	
	}
//Shipping Method
public void clickShippingMethod()
{
	
 wait.until(ExpectedConditions.elementToBeClickable(shippingMethod)).click();
 test.log(LogStatus.PASS,"Shipping Method is selected");

	}
public void clickShippingMethodConti()
{
	  test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));  
		
	wait.until(ExpectedConditions.elementToBeClickable(continueBtnShipMeth)).click();
	 test.log(LogStatus.PASS,"Clicked on Continue Button of Shipping Address ");


	}

//Payment Method
public void clickPaymentMethod()
{
	wait.until(ExpectedConditions.elementToBeClickable(paymentMethod)).click();
	 test.log(LogStatus.PASS,"Clicked on Payment Method");

	
}
public void clickContinueButtonPaymentMethod()
{
	  test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));  
		
	wait.until(ExpectedConditions.elementToBeClickable(continueBtnPayMeth)).click();
	test.log(LogStatus.PASS,"Clicked on Payment Method Continue Button");

	}
//div[@class='info']//table/tbody[1]/tr[1]/td[1]/p[1]

//Payment Information
public void verifyPaymentText() throws InterruptedException
{
	Thread.sleep(3000);
	String str= paymentText.getText();
	Assert.assertEquals(str, "You will pay by COD");
	test.log(LogStatus.PASS,"Verified Payment Text: "+str);
	}
public void clickContinueButtonPaymentInform()
{
	  test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));  
		
	wait.until(ExpectedConditions.elementToBeClickable(continueBtnPayInfor)).click();
	test.log(LogStatus.PASS,"Clicked on Payment Information Continue Button");

	}

//Confirm Order
public void clickConfirmOrderBtn()
{
	  test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));  
		
	wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn)).click();
	test.log(LogStatus.PASS,"Clicked on confirm Order Button");


	}
//Checkout Completed
public void verifyCheckOutText() throws InterruptedException
{
	Thread.sleep(3000);
	String str = successMessage.getText();
	Assert.assertEquals(str, "Your order has been successfully processed!");
	test.log(LogStatus.PASS,"Verified Checkout Text " +str);
	}
public void getOrderNumber()
{
	String number = orderNumber.getText();
System.out.println(number);
test.log(LogStatus.PASS,"Order Number " +number);

}
public void clickContineSuccess()
{
	  test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));  
		
	wait.until(ExpectedConditions.elementToBeClickable(contineSuccess)).click();
	test.log(LogStatus.PASS,"Clicked on Contine Success button");
	

	}

}
