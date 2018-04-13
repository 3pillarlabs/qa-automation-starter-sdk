package com.tpg.quality.web.sample.pages;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.relevantcodes.extentreports.LogStatus;
import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.sample.locators.LandingPageObjects;
import com.tpg.quality.web.utility.ExtentTestManager;

@Component
public class LandingPage {
	@Inject
	private Webdriver driverobj;
	@Inject
	private LandingPageObjects landingPageObj;

	LandingPageObjects landingPageElements = null;
	// static Logger logger = Logger.getLogger(LandingPage.class);


	public void openLandingPage(String url) {

		driverobj.getDriver().get(url);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to URL "+url);
		// logger.info("Opened the link " + url);
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
	}

	public void enterUsername(String username) {

		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter text "+username+" in field Username");
		landingPageElements.login.setText(username);
		// logger.info("Clicked login");
	}

	public void enterPassword(String password) {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter text "+password+" in field Password");
		landingPageElements.password.setText(password);
		// logger.info("Clicked login");
	}

	public void clickLogIn() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Going to click on Login Button");
		landingPageElements.submit.click();
		// logger.info("Entered password");
	}

	public void clickReset() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Going to click on Reset Button");
		landingPageElements.reset.click();
		// logger.info("Entered password");
	}

	public void clickRegiserLink() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Going to click on Register link");
		landingPageElements.registerationLink.click();
		// logger.info("Entered username");
	}


	public void invokePage(){
		landingPageElements = null;
		landingPageElements = landingPageObj.initElements(driverobj.getDriver());


	}
}
