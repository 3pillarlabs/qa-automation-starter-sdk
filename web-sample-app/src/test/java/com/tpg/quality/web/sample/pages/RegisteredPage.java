package com.tpg.quality.web.sample.pages;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.relevantcodes.extentreports.LogStatus;
import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.sample.locators.RegisteredPageObjects;
import com.tpg.quality.web.utility.ExtentTestManager;

@Component
public class RegisteredPage {
	@Inject
	private Webdriver driverobj;
	@Inject
	private RegisteredPageObjects registeredPageObj;

	RegisteredPageObjects registeredPageElements = null;


	public void clickLoginLink() {
		if (registeredPageElements == null) {
			registeredPageElements = registeredPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Going to click on Login link ");
		registeredPageElements.loginPagelink.click();
	}

	public void verifyRegisteration() {
		if (registeredPageElements == null) {
			registeredPageElements = registeredPageObj.initElements(driverobj.getDriver());
		}
		if (registeredPageElements.successMsg.getText().contains("successful")){
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is registered succesfully");

		}
	}

	public void invokePage(){
		registeredPageElements = null;
		registeredPageElements = registeredPageObj.initElements(driverobj.getDriver());


	}
}
