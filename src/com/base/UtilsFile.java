package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class UtilsFile {
	
	static DataFormatter formatter;

	public static ExtentReports extent;
	public static ExtentTest test;
	public static String reportName;
	public static Capabilities caps ;

	public static String Readexcel(String InputFile,String name,int r, int c) throws Exception 
	{
		File src=new File("InputFile\\"+InputFile+".xlsx");
		
		
		FileInputStream fis=new FileInputStream(src);
	
	    
	    try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(name);
			Row row = sheet.getRow(r-1);
			Cell cell = row.getCell(c-1);
    formatter = new DataFormatter();
	    String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
	    
	}
		
	 public static String GeneralScreenShot(WebDriver driver) {
		   
		    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    String encodedBase64 = null;
		    FileInputStream fileInputStreamReader = null;
		    try {
		        fileInputStreamReader = new FileInputStream(scrFile);
		        byte[] bytes = new byte[(int)scrFile.length()];
		        fileInputStreamReader.read(bytes);
		        encodedBase64 = new String(Base64.encodeBase64(bytes));
		    } catch (Exception e) {
		       System.out.println(e);
		    }
		    return "data:image/png;base64,"+encodedBase64;
		}





}