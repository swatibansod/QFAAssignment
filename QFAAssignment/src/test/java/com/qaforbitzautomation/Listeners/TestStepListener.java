package com.qaforbitzautomation.Listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qmetry.qaf.automation.step.QAFTestStepAdapter;
import com.qmetry.qaf.automation.step.StepExecutionTracker;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Reporter;

public class TestStepListener extends QAFTestStepAdapter {
	Log logger = LogFactory.getLog(getClass());

	@Override
    public void afterExecute(StepExecutionTracker stepExecutionTracker) {
        /*long duration = (stepExecutionTracker.getEndTime() - stepExecutionTracker.getStartTime()) / 1000;
        if (stepExecutionTracker.getStep().getThreshold() > duration)
            stepExecutionTracker.setVerificationError("Threshold value is exceed");*/
		Reporter.log("this is the test listener");
		
        
    }


}
