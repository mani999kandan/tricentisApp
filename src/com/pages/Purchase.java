package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class Purchase extends TestBase {

	WebDriverWait wait = new WebDriverWait(driver, 10);
	public Purchase(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//a[normalize-space()='testdemowebshop@gmail.com']") WebElement accountID;

	@FindBy(xpath="//a[text()[normalize-space()='Books']]") WebElement books;
	@FindBy(xpath="//h2[@class='product-title']//a") WebElement bookSelect;
	@FindBy(xpath="//span[@class='price-value-13']") WebElement getPrice;
	@FindBy(id="addtocart_13_EnteredQuantity") WebElement quantity;
	@FindBy(id="add-to-cart-button-13") WebElement cart;
	@FindBy(xpath="//p[text()='The product has been added to your ']") WebElement cartMessage;
	@FindBy(xpath="//a[@href='/cart']//span[1]") WebElement cartLink;
	@FindBy(xpath="//div[text()[normalize-space()='Your Shopping Cart is empty!']]") WebElement cartVerify;
	@FindBy(xpath="//input[@name='removefromcart']") WebElement removeCart;
	@FindBy(name="updatecart") WebElement updateCart;

	public void verifyAccountID(String emailAddress) throws InterruptedException
	{
		
		
		String Header = accountID.getText();
		Assert.assertEquals(Header, emailAddress);
		}
	
	public void clickBooksCategory() throws Exception
	{
		 wait.until(ExpectedConditions.elementToBeClickable(books)).click();
		 test.log(LogStatus.PASS,"Clicked on Category - Books");
			
		}
	public void selectBook() throws Exception
	{
		bookSelect.click();
		 test.log(LogStatus.PASS,"Selected Books");
			
		}

	public String getPriceDetails() throws Exception
	{
		 String Unitprice=getPrice.getText();
		 test.log(LogStatus.PASS,"Get the unit price of the selected item: " +Unitprice);
		 return Unitprice;
		
		}
	public void enterQuantity(String quanValue) 
	{
		
		quantity.clear();
		quantity.sendKeys(quanValue);
		 test.log(LogStatus.PASS,"Entered Quantity " +quanValue);
		 test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));   
					
	}
	public void clickCartBtn() throws Exception
	{
		cart.click();
		 test.log(LogStatus.PASS,"Clicked Add Cart Button");
			
		Thread.sleep(2000);
		}
	public void verifyCartMessage() throws InterruptedException
	{
		String expectedMessage = "The product has been added to your shopping cart";
		cartMessage.isDisplayed();
		String Header = cartMessage.getText();
		System.out.println(Header);
	
		Assert.assertEquals(Header, expectedMessage);
		 test.log(LogStatus.PASS,"Verified the Success Message: " +expectedMessage);
		 test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));   
				
		}

public void clickCartLink() 
{
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", cartLink);
	 test.log(LogStatus.PASS,"Clicked on Cart Link ");
		

	}

public int verifyCartStatus() 
{
	
int s1=	driver.findElements(By.xpath("//div[text()[normalize-space()='Your Shopping Cart is empty!']]")).size();
test.log(LogStatus.PASS,"Verified Cart Status ");
return s1;

	}
public void clickRemoveCartCheck() 
{
	 wait.until(ExpectedConditions.elementToBeClickable(removeCart)).click();
	 test.log(LogStatus.PASS,"Clicked on Remove Cart");
		

	}
public void clickUpdateCartBtn() 
{
	updateCart.click();
	 test.log(LogStatus.PASS,"Clicked on Update Cart button");
		
	 test.log(LogStatus.PASS,test.addScreenCapture(GeneralScreenShot(driver)));   
		
	}

}
