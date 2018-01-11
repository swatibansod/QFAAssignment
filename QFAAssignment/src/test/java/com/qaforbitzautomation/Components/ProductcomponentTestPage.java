package com.qaforbitzautomation.Components;

import org.openqa.selenium.By;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductcomponentTestPage extends QAFWebComponent{

	public ProductcomponentTestPage(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(locator = "flight.image")
	private QAFWebElement flightimage;
	@FindBy(locator = "flight.time")
	private QAFWebElement flighttime;
	@FindBy(locator = "flight.arrivalTime")
	private QAFWebElement flightarrivalTime;
	@FindBy(locator = "flight.stop")
	private QAFWebElement flightstop;
	
	public QAFWebElement getFlightImage() {
		return flightimage;
	}
	
	public QAFWebElement getflightarrivalTime() {
		return flightarrivalTime;
	}
	
	public QAFWebElement getflightstop() {
		return flightstop;
	}
	

	public QAFWebElement getFlightTime() {
		return flighttime;
	}

	
}
