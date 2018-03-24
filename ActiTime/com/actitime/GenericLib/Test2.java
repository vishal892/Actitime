package com.actitime.GenericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
			
			System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
			WebDriver d=new FirefoxDriver();
			Thread.sleep(5000);
			d.close();

	}

}
