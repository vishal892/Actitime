package com.actitime.ProjectAndCustomerTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.GenericLib.Constants;
import com.actitime.GenericLib.Driver;
import com.actitime.GenericLib.ExcelLib6;
import com.actitime.GenericLib.WebdriverCommonLib6;

public class ProjectAndCustomerTest6Old {   //Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR
	ExcelLib6 eLib6=new ExcelLib6();
	WebdriverCommonLib6 wLib6=new WebdriverCommonLib6();
	
	@Test
	public void CreateCustomerTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		
//		//step1: Read/get the data from workbook/excelSheet
//		String UserNameData=eLib6.getExcelData("Sheet1", 1, 2);
//		//Note: here not required System.out.println(UserNameData); , Because i have already print DATA in ExcelLib Class ex:{{System.out.println(DATA);}}
//		// so, it will print DATA automatically
//		String PasswordData=eLib6.getExcelData("Sheet1", 1, 3);
//		String companyName=eLib6.getExcelData("Sheet1", 1, 4);
	////////////////////////////////////////////////////////////////////////
		//step2: Write/Set the DATA into Excelsheet/workbook
//		eLib5.setExcelData("Sheet1", 8, 4, "HELLO PRAMOD");
//		eLib5.setExcelData("Sheet1", 9, 3, "Nagarjuna");
//		eLib5.setExcelData("Sheet1", 7, 2, "Bhola@gmail.com");
	/////////////***************//////////////////////////////////
		//get some new data from excelsheet
		String CustomerName=eLib6.getExcelData("Sheet1", 1, 6);
		System.out.println(CustomerName);
		String ProjectName=eLib6.getExcelData("Sheet1", 1, 7);
		System.out.println(ProjectName);

	////////////yyyyyyyyyyyyyyyyy///////////////////////////////////////
		//get Global Data from Constants interface
		String USERNAME=Constants.UserName1;
		String PASSWORD=Constants.PassWord1;
		String URL=Constants.Url1;
		//Now here i m going to use Driver Concept
		Driver.d =Driver.getBrowser();  // yaa  getDriver()
		Driver.d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.d.get(URL);
		Driver.d.findElement(By.name("username")).sendKeys(USERNAME);
		Driver.d.findElement(By.name("pwd")).sendKeys(PASSWORD);
		Driver.d.findElement(By.id("loginButton")).click();
		
	}
}