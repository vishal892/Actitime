package com.actitime.PageObjectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.GenericLib.WebdriverCommonLib6;

public class OpenTasks extends WebdriverCommonLib6 { //Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR
	
	@FindBy(linkText="Projects & Customers")
	private WebElement ProjectsAndCustomersLinkWb;
	
	public void NavigateToProjectAndCustomerPage(){
		waitForLinkTextPresent("Projects & Customers");
		ProjectsAndCustomersLinkWb.click();
	}
	

}
