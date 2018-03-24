package com.actitime.GenericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.GenericLib.Driver;

public class WebdriverCommonLib6 { //Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR
	
	WebDriverWait wait;  //here i have declared WebDriverWait object for not need to mension in next lines, method, or in testscripts
	//means i had reduced the code
	Select sel; //here i have declared WebDriverWait object
	Alert alt;  //here i have declared WebDriverWait object
	//in this WebDriverCommonLib Class i will store all webdriver wait, selects, verify, actions, handle popups
	//here i will strore all things which is common for webdriver means methods,actions,waitStatements,...
	
	//1.1  wait statement for xpath     //Note: Here  Driver is extends from Driver Class(Uper)
		public void waitForXpathPresent(String XpathOfWb){ //if i will use this technique, then we not need to pass wait statement in b/w during testScript
			wait = new WebDriverWait(Driver.d, 20);     ///this is very important and time saving
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(XpathOfWb)));
		}
		
		
		//1.2  wait statement for LinkText
		public void waitForLinkTextPresent(String LinkName){
			wait = new WebDriverWait(Driver.d, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LinkName)));
		}

	
	//1.3  wait statement for Name     //Note: Here  Driver is extends from Driver Class(Uper)
	public void WaitForNamePresent(String Name){
		Driver.d.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
	}
	
	
	//1.4  wait statement for id     //Note: Here  Driver is extends from Driver Class(Uper)
	public void WaitForIdPresent(String Id){
		Driver.d.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		
	}
	
	//1.5  wait statement for PageLoad     //Note: Here  Driver is extends from Driver Class(Uper)
		public void waitForPageToLoad(){
			Driver.d.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		}
	
	
	
///////////*********************///////////////////////////////////	
	//2.1  select   for visibleText
	public void select(WebElement selWb , String value){
		sel = new Select(selWb);
		sel.selectByVisibleText(value);
	}
	
	//2.2   select   for index Based
	public void select(WebElement selWb , int index){
		sel = new Select(selWb);
		sel.selectByIndex(index);
	}
	////////////////***********************/////////////////////////////
	//3    Verify  Text
	public boolean verifyText(WebElement wb , String expectedVal){
		boolean flag = false;
		String actVal = wb.getText();
		System.out.println(actVal);
		if(actVal.equals(expectedVal)){
			flag = true;
			System.out.println(expectedVal + "is verfied==PASS");
		}else{
			System.out.println(expectedVal + "is not verfied==FAIL");

		}
		return flag;
	}
	//////////////////////////************************///////////////////////////
	//4.1  Handle Alert Popup to do Accept (OK)
	public void acceptAlert(){
		alt=Driver.d.switchTo().alert();  // 1st get control on alert
		System.out.println(alt.getText());
		alt.accept();
	}
	
	
	//4.1  Handle Alert Popup to do Dismiss (CANCEL)-- it is not mandatory
	public void CancelAlert(){
		alt=Driver.d.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
	}
	////////////////////////mmmmmmmmmmmmmmmmmm//////////////////////////////////
	
	
	
	

}
