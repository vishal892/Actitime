package com.actitime.PageObjectRepositoryLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import com.actitime.GenericLib.Constants;
import com.actitime.GenericLib.Driver;

public class Login {  //Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR
	@FindBy(id="username")
	private WebElement UsernameEdt;
	@FindBy(name="pwd")
	private WebElement PasswordEdt;
	@FindBy(xpath="//div[normalize-space(text())='Login']")
	private WebElement LoginBtn;
	
	//public void LoginToApp(String UserName1,String PassWord1, String Url1){
		public void LoginToApp(String UserName2,String PassWord2) throws InterruptedException{

			Driver.d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			
		Driver.d.get(Constants.Url1);
		
//		UsernameEdt.sendKeys(UserName2);
//		PasswordEdt.sendKeys(PassWord2);
		
		UsernameEdt.sendKeys(Constants.UserName1);
		PasswordEdt.sendKeys(Constants.PassWord1);

		LoginBtn.click();
		
		
	}
	
	
	
	
	
	
	

}
