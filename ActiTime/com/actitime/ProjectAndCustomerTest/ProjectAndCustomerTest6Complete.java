package com.actitime.ProjectAndCustomerTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.GenericLib.Constants;
import com.actitime.GenericLib.Driver;
import com.actitime.GenericLib.ExcelLib6;
import com.actitime.GenericLib.ScreenShot;
import com.actitime.GenericLib.WebdriverCommonLib6;
import com.actitime.PageObjectRepositoryLib.ActiveProjectsAndCustomers;
import com.actitime.PageObjectRepositoryLib.Common;
import com.actitime.PageObjectRepositoryLib.CreateNewCustomer;
import com.actitime.PageObjectRepositoryLib.EditCustomerInformation;
import com.actitime.PageObjectRepositoryLib.EnterTimeTrack;
import com.actitime.PageObjectRepositoryLib.Login;
import com.actitime.PageObjectRepositoryLib.OpenTasks;
import com.actitime.PageObjectRepositoryLib.EditCustomerInformation;
import com.actitime.PageObjectRepositoryLib.EditCustomerInformation;

public class ProjectAndCustomerTest6Complete {
  
	//object deceleration
			ExcelLib6 eLib6;
			WebdriverCommonLib6 wLib6;
			WebDriver d;
			Login LoginPageObj;
			EnterTimeTrack EnterTimeTrackPageObj;
			OpenTasks OpenTasksPageObj;
			ActiveProjectsAndCustomers activeProjectsAndCustomersPageObj;
			CreateNewCustomer createNewCustomerPageObj;
			EditCustomerInformation EditCustomerInformationPageObj;
			Common CommonPageObj;
			ScreenShot ScreenShotObj;
			
			@BeforeClass
			  public void ConfigBeforeClass() {
				eLib6=new ExcelLib6();
				Driver.d =Driver.getBrowser();  // yaa  getDriver()
				wLib6=new WebdriverCommonLib6();
				LoginPageObj=PageFactory.initElements(Driver.d, Login.class);
				//LoginPageObj.LoginToApp(UserName1, PassWord1);
			    EnterTimeTrackPageObj=PageFactory.initElements(Driver.d, EnterTimeTrack.class);
				OpenTasksPageObj=PageFactory.initElements(Driver.d, OpenTasks.class);
				activeProjectsAndCustomersPageObj=PageFactory.initElements(Driver.d, ActiveProjectsAndCustomers.class);
				createNewCustomerPageObj=PageFactory.initElements(Driver.d, CreateNewCustomer.class);
				EditCustomerInformationPageObj=PageFactory.initElements(Driver.d, EditCustomerInformation.class);
				CommonPageObj=PageFactory.initElements(Driver.d, Common.class);	
				ScreenShotObj=PageFactory.initElements(Driver.d, ScreenShot.class);
			  }
		//  Note: without //object deceleration we can't do forword steps from here,so we have to do must&should"object deceleration"
			
		
			 @BeforeMethod
			  public void ConfigBeforeMethod() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
				  //step1: Read/get the data from workbook/excelSheet
					String UserNameData=eLib6.getExcelData("Sheet1", 1, 2);
					//Note: here not required System.out.println(UserName); , Because i have already print DATA in ExcelLib Class ex:{{System.out.println(DATA);}}
					// so, it will print DATA automatically
					String PasswordData=eLib6.getExcelData("Sheet1", 1, 3);

					//get Glovbal test data from Constants
					String USERNAME=Constants.UserName1;
					String PASSWORD=Constants.PassWord1;
					//LoginPageObj.LoginToApp(USERNAME, PASSWORD);
					LoginPageObj.LoginToApp(Constants.UserName1, Constants.PassWord1);
			  }
			 
			 
	  @Test
	  public void CreateCustomerTest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		  String CustomerName=eLib6.getExcelData("Sheet1", 1, 6);
			System.out.println(CustomerName);
			
			//step2 : navigate to create Customer Page
			EnterTimeTrackPageObj.NavigateToTasksPage();
			OpenTasksPageObj.NavigateToProjectAndCustomerPage();
			//step 3 : create Customer
			activeProjectsAndCustomersPageObj.NavigateToCustomerPage();
			createNewCustomerPageObj.CreateCustomer(CustomerName);
			//step 4 : navigate to Customer details Page
			activeProjectsAndCustomersPageObj.NavigateToCustomerDetailsPage(CustomerName);
			//step 5 : verify Customer details
			EditCustomerInformationPageObj=PageFactory.initElements(Driver.d, EditCustomerInformation.class);
			String actualCustomer = EditCustomerInformationPageObj.getCustomerNameInformation().getText();
			Assert.assertEquals(actualCustomer, CustomerName,"customerName is not verified==FAIL");
	  }
	 
	  @Test
	  public void ModifyCustomerTest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		  String CustomerName2=eLib6.getExcelData("Sheet2", 1, 6);
			System.out.println(CustomerName2);
			String[] CustomerName2Arr = CustomerName2.split(";");
			//step2 : navigate to create Customer Page
					EnterTimeTrackPageObj.NavigateToTasksPage();
					OpenTasksPageObj.NavigateToProjectAndCustomerPage();
					//step 3 : create Customer
					activeProjectsAndCustomersPageObj.NavigateToCustomerPage();
					createNewCustomerPageObj.CreateCustomer(CustomerName2Arr[0]);
					//step 4 : navigate to Customer details Page
					activeProjectsAndCustomersPageObj.NavigateToCustomerDetailsPage(CustomerName2Arr[0]);
					//step 5 : modify & verify Customer details
					EditCustomerInformationPageObj=PageFactory.initElements(Driver.d, EditCustomerInformation.class);
					String actualCustomer = EditCustomerInformationPageObj.getCustomerNameInformation().getText();
					Assert.assertEquals(actualCustomer, CustomerName2Arr[0],"customerName is not verified==FAIL");
	  }

	  @AfterMethod
	  public void ConfigAfterMethod() {
		  CommonPageObj.DoLogOut();
	  }

	  

	  @AfterClass
	  public void ConfigAfterClass() {
		  Driver.d.close();
	  }

	  
	
	  
	}
	
