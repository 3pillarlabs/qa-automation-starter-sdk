package com.tpg.quality.web.sample.pages;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.sample.locators.LandingPageObjects;

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
		// logger.info("Opened the link " + url);
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
	}

	public void enterUsername(String username) {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.login.setText(username);
		// logger.info("Clicked login");
	}

	public void enterPassword(String password) {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.password.setText(password);
		// logger.info("Clicked login");
	}

	public void clickLogIn() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.submit.click();
		// logger.info("Entered password");
	}

	public void clickReset() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.reset.click();
		// logger.info("Entered password");
	}

	public void clickRegiserLink() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.registerationLink.click();
		// logger.info("Entered username");
	}



}
