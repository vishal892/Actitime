package com.actitime.PageObjectRepositoryLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.GenericLib.Constants;
import com.actitime.GenericLib.Driver;
import com.actitime.GenericLib.WebdriverCommonLib6;
///////Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR

public class ActiveProjectsAndCustomers extends WebdriverCommonLib6{
	@FindBy(xpath="//input[@value='Create New Customer']")
	private WebElement CreateNewCustomerBtn;
	
	@FindBy(xpath="//input[@value='Create New Project']")
	private WebElement CreateNewProjectBtn;
	
	@FindBy(name="selectedCustomer")
	private WebElement selectedCustomerLst;
	
	@FindBy(xpath="//input[contains(@value,'Show')]")
	private WebElement ShowBtn;
	
	public void NavigateToCustomerDetailsPage(String CustomerName){
		select(selectedCustomerLst, CustomerName);
		ShowBtn.click();
		Driver.d.findElement(By.linkText(CustomerName)).click();	
	}
	
	
	public void NavigateToCustomerPage(){
		CreateNewCustomerBtn.click();
	}
	
	
	public void NavigateToProjectPage(){
		CreateNewProjectBtn.click();
	}
	
	
	

}
