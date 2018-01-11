package com.qaforbitzautomation.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qaforbitzautomation.Pages.QaforbitzHomepage;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class QaforbitzTestCases extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	@Test
	public void orbizTestCases() throws InterruptedException
	{
		QaforbitzHomepage orbizTestCases = new QaforbitzHomepage();
		orbizTestCases.launchPage(null);
		//orbizTestCases.verifyOrbitzLaunchedProperly();
		
		orbizTestCases.orbitzBooking("Flights","Pune, India (PNQ-Lohegaon)","Nagpur, India (NAG-Dr. Ambedkar Intl.)","01/11/2018","02/09/2018");
		orbizTestCases.verifyListofFlights();
		
	}
	
}
