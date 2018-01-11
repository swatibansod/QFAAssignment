package com.qaforbitzautomation.Listeners;

import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.Response;
import org.testng.Reporter;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElementCommandAdapter;
import com.qmetry.qaf.automation.util.StringUtil;

public class WebElementListener extends QAFWebElementCommandAdapter {

	@Override
    public void beforeCommand(QAFExtendedWebElement element, CommandTracker commandTracker) {
		Reporter.log("Webelement Listener");
		System.out.println("Webelement Listener");
        if (commandTracker.getCommand().equalsIgnoreCase(DriverCommand.SEND_KEYS_TO_ELEMENT)) {
            element.clear();
            // you access/modify any parameter!
            String value = String.valueOf(commandTracker.getParameters().get("value"));
            if (StringUtil.isBlank(value)) {
                // No need to send key
                // ignore actual command
                commandTracker.setResponce(new Response());
            }
        }
    }


}
