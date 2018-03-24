package com.actitime.PageObjectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerInformation {//Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR
	
	@FindBy(className="formsummarytext")  ///Ex: kitta Ready Text 
	private WebElement customerNameInfo;

	public WebElement getCustomerNameInformation() {
		return customerNameInfo;
	}
	
	
	
	
	

}
