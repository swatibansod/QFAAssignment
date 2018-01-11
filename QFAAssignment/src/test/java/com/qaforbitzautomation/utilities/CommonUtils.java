package com.qaforbitzautomation.utilities;

import java.util.HashMap;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;



public class CommonUtils
{
	
	
	
	public static void swithToWindow(QAFWebDriver driver)
	{
		for(String handle : driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
		
	}
	
}
