package com.qaforbitzautomation.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.qaforbitzautomation.Components.ProductcomponentTestPage;
import com.qaforbitzautomation.utilities.CommonUtils;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.testng.report.Report;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class QaforbitzHomepage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		driver.manage().deleteAllCookies();
		driver.get("/");
		driver.manage().window().maximize();
	}

	@FindBy(locator = "QAFHomePage.flight.lnk")
	private QAFWebElement QAFHomePageflightlnk;
	@FindBy(locator = "QAFHomePage.flightFrom.input")
	private QAFWebElement QAFHomePageflightFrominput;
	@FindBy(locator = "QAFHomePage.flightTo.input")
	private QAFWebElement QAFHomePageflightToinputk;
	@FindBy(locator = "QAFHomePage.flightdepart.date")
	private QAFWebElement QAFHomePageflightdepartdate;
	@FindBy(locator = "QAFHomePage.flightreturn.date")
	private QAFWebElement QAFHomePageflightreturndate;
	@FindBy(locator ="QAFHomePage.Search.button")
	private QAFWebElement QAFHomePageSearchbutton;
	
	@FindBy(locator = "all.flights")
	private List<ProductcomponentTestPage> allflights;
	
	public List<ProductcomponentTestPage> getSearchflights()
	{
		
		return allflights;
	}
	public QAFWebElement getflightName()
	
	{
		return QAFHomePageflightlnk;
	}
	
	
	public void verifyOrbitzLaunchedProperly() throws InterruptedException
	{
		if(driver.getWindowHandles().size()>1)
		{
			CommonUtils.swithToWindow(driver);
		}
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		Validator.verifyThat("Orbitz is launched properly", driver.getTitle(), Matchers.containsString("ORBITZ.com – Best Travel Deals"));
	}
	
	public void orbitzBooking(String BookingName, String Source, String destination, String departureDate,String returnDate)
	{
		
		QAFExtendedWebElement selectBooking= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("QAFHomePage.flight.lnk"), BookingName));
		selectBooking.waitForVisible();
		System.out.println(selectBooking.getText());
		selectBooking.click();
		
		QAFHomePageflightFrominput.sendKeys(Source);
	
		QAFHomePageflightToinputk.sendKeys(destination);
	
		QAFHomePageflightdepartdate.sendKeys(departureDate);
		QAFHomePageflightreturndate.clear();
		QAFHomePageflightreturndate.sendKeys(returnDate);
		QAFHomePageSearchbutton.click();
		
	}
	public void verifyListofFlights() throws InterruptedException
	{
		
		List<ProductcomponentTestPage> productcomponent = getSearchflights();
		//System.out.println(productcomponent.size());
		//Thread.sleep(5000);
		Validator.verifyThat(productcomponent.size(), Matchers.greaterThan(0));
		
		for(ProductcomponentTestPage result : productcomponent) {
			Reporter.log("1. "+result.getFlightTime().getText().trim());
			Reporter.log("2. "+result.getflightarrivalTime().getText().trim());
			Reporter.log("3. "+result.getflightstop().getText().trim());
			Reporter.log("4. "+result.getFlightImage().verifyVisible());

		}
}
}
