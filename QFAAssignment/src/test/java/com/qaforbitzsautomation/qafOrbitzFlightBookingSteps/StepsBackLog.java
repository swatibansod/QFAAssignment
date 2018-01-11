/**
 * 
 */
package com.qaforbitzsautomation.qafOrbitzFlightBookingSteps;

import com.qaforbitzautomation.Pages.QaforbitzHomepage;
import com.qmetry.qaf.automation.step.NotYetImplementedException;
import com.qmetry.qaf.automation.step.QAFTestStep;

/**
 * @author Swati.Bansod
 */
public class StepsBackLog {

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	QaforbitzHomepage orbizTestCases = new QaforbitzHomepage();

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user launch the application")
	public void userLaunchTheApplication() {
		orbizTestCases.launchPage(null);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user books the flight using {0},{1},{2},{3},{4}")
	public void userBooksTheFlightUsing(String str0, String str1, String str2,
			String str3, String str4) {
		orbizTestCases.orbitzBooking("Flights","Pune, India (PNQ-Lohegaon)","Nagpur, India (NAG-Dr. Ambedkar Intl.)","01/11/2018","02/09/2018");
	}

	/**
	* Auto-generated code snippet by QMetry Automation Framework.
	 * @throws InterruptedException 
	*/
	@QAFTestStep(description="user verify the results")
	public void userVerifyTheResults() throws InterruptedException{
		orbizTestCases.verifyListofFlights();
	}

	/**
	* Auto-generated code snippet by QMetry Automation Framework.
	*/
	@QAFTestStep(description="To book the flight fron Orbitz")
	public void toBookTheFlightFronOrbitz(){
		//TODO: remove NotYetImplementedException and call test steps
		throw new NotYetImplementedException();
	}

}
