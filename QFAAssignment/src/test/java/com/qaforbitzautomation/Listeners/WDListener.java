package com.qaforbitzautomation.Listeners;

import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.Response;
import org.testng.Reporter;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriverCommandAdapter;
import com.qmetry.qaf.automation.util.StringUtil;



public class WDListener extends QAFWebDriverCommandAdapter {

	
	Log logger = LogFactory.getLog(getClass());
    @Override
    public void beforeCommand(QAFExtendedWebDriver driver, CommandTracker commandTracker) {
        super.beforeCommand(driver, commandTracker);
        Reporter.log("Webdriver Listener");
        System.out.println("webdriver listener");
        String command = commandTracker.getCommand();
        Map<String, Object> params = commandTracker.getParameters();
        // support selenium 1 api for navigating from frame to main window
        // with selenium.selectFrame("");
        if (command.equalsIgnoreCase(DriverCommand.SWITCH_TO_FRAME) && StringUtil.isBlank((String) params.get("id"))) {
            String mainWindow = driver.getWindowHandle();
            params.put("id", mainWindow);
            driver.switchTo().window(mainWindow);
            // skip original command execution
            commandTracker.setResponce(new Response());
        }
        if (command.equalsIgnoreCase(DriverCommand.SWITCH_TO_WINDOW)) {
            String targetWindow = String.valueOf(commandTracker.getParameters().get("name"));
            String parentHandle = driver.getWindowHandle();
            if (!targetWindow.equalsIgnoreCase(parentHandle)) {
                // store the parent window handle
                ConfigurationManager.getBundle().setProperty("parentWindowHandel", parentHandle);
               
            }
        }
    }
    @Override
    public void onFailure(QAFExtendedWebDriver driver, CommandTracker commandTracker) {
        super.onFailure(driver, commandTracker);
        if (commandTracker.getCommand().equalsIgnoreCase(DriverCommand.SWITCH_TO_WINDOW)
                && commandTracker.hasException()) {
            Set<String> windows = driver.getWindowHandles();
            String parentWindowHandel = ConfigurationManager.getBundle().getString("parentWindowHandel");
            for (String window : windows) {
                if (!parentWindowHandel.equalsIgnoreCase(window)) {
                    driver.switchTo().window(window);
                    // now we can remove the exception, it is handled!
                    commandTracker.setException(null);
                    break;
                }
            }
        }
    }


    

}
