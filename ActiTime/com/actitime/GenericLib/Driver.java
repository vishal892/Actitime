package com.actitime.GenericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.actitime.GenericLib.Constants;

public class Driver { //Concept of use only ExcelLib+Constants+Driver+WebDriverCommonLib+POR
	public static WebDriver d; //Note: here i have created local variable of Driver, because i need to return Driver so, i have initilized Driver

	public static WebDriver getBrowser(){  // yaa getDriver()
		
		if(Constants.BROWSER.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\vivaan\\eclipse-workspace\\BATCH_EXECUTION\\Resources\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
		}else if(Constants.BROWSER.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vivaan\\eclipse-workspace\\BATCH_EXECUTION\\Resources\\chromedriver.exe");
			d=new ChromeDriver();
		}else{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vivaan\\eclipse-workspace\\BATCH_EXECUTION\\Resources\\geckodriver.exe");
			d=new FirefoxDriver();
			
		}
		
		return d;  //here i got return Driver After initilize local variable upper side
	}
	

	
}
