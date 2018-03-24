package com.actitime.PageObjectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomer {//Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR
	
	@FindBy(name="name")
	private WebElement customerNameEdt;
	
	
	@FindBy(xpath="//input[@value='Create Customer']")
	private WebElement createCustomerBtn;
	
	public void CreateCustomer(String CustomerName1){
		customerNameEdt.sendKeys(CustomerName1);
		createCustomerBtn.click();
	}
	

	
}
