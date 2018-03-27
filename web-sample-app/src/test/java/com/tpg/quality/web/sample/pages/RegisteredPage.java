package com.tpg.quality.web.sample.pages;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.sample.locators.RegisteredPageObjects;

@Component
public class RegisteredPage {
	@Inject
	private Webdriver driverobj;
	@Inject
	private RegisteredPageObjects registeredPageObj;

	RegisteredPageObjects registeredPageElements = null;
	// static Logger logger = Logger.getLogger(LandingPage.class);


	public void clickLoginLink() {
		if (registeredPageElements == null) {
			registeredPageElements = registeredPageObj.initElements(driverobj.getDriver());
		}
		registeredPageElements.loginPagelink.click();
		// logger.info("Entered username");
	}

	public void verifyRegisteration() {
		if (registeredPageElements == null) {
			registeredPageElements = registeredPageObj.initElements(driverobj.getDriver());
		}
		if (registeredPageElements.successMsg.getText().contains("successful")){
			//logger.info("User is registered successfully ");

		}
	}
}
