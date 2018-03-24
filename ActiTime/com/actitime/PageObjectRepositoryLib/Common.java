package com.actitime.PageObjectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR

public class Common {  //yaa Logout
	

	@FindBy(linkText="Logout")
	private WebElement logOutLinkwb;
	
	
	public void DoLogOut(){
		logOutLinkwb.click();
	}
	
	

}
