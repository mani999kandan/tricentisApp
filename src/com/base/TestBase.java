package com.base;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase extends UtilsFile{
	public static WebDriver driver;
	@BeforeSuite
	public void launch() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\TempoSmokeAutoCode\\Jenkins\\drivers\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.get("http://demowebshop.tricentis.com/");
		   driver.manage().window().maximize();
			caps= ((RemoteWebDriver) driver).getCapabilities();
		   StartReport();
	}
	@AfterSuite
	public void close()
	{
		driver.quit();
		  extent.close();
	}
	
	public void StartReport() throws Exception
	{ 
	String url="http://demowebshop.tricentis.com/";
		
		 reportName=".//Reports//Extent_Report.html";
	 extent=new ExtentReports(reportName,true);
	 extent.addSystemInfo("Browser", caps.getBrowserName().toUpperCase());
	 extent.addSystemInfo("Version", caps.getVersion());
	 extent.addSystemInfo("Environment", url);
	 extent.addSystemInfo("Environment title", driver.getTitle());
	
	}
	@BeforeMethod 
	  public void StartTest(Method m) 
	{
		     test = extent.startTest(this.getClass().getSimpleName() +" - "+  m.getName());			
			 test.assignCategory(this.getClass().getSimpleName());	
		

	}	
	@AfterMethod (alwaysRun=true)
	 public void failure(ITestResult result) throws Exception
	 {
		 
	      if(ITestResult.FAILURE==result.getStatus())
	     {
	        test.log(LogStatus.FAIL,test.addScreenCapture(GeneralScreenShot(driver)));
	        test.log(LogStatus.FAIL, result.getThrowable()); 
	       }
	        extent.endTest(test);   
	        extent.flush();        
	 }
		 
}
