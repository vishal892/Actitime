package com.actitime.PageObjectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.GenericLib.WebdriverCommonLib6;

public class EnterTimeTrack extends WebdriverCommonLib6{//Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR
	
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement TasksImg;
	
	public void NavigateToTasksPage(){
		waitForXpathPresent("//div[text()='Tasks']");
		TasksImg.click();
		
	}
	
	
	

}
