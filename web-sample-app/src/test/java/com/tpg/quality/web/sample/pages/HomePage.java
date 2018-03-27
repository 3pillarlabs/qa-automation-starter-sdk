package com.tpg.quality.web.sample.pages;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.sample.locators.HomePageObjects;

@Component
public class HomePage {

	// static Logger logger = Logger.getLogger(HomePage.class);
	@Inject
	private Webdriver driverobj;
	@Inject
	private HomePageObjects homePageObj;

	HomePageObjects homePageElements = null;

	public void verifyHomePage() {
		if (homePageElements == null) {
			homePageElements = homePageObj.initElements(driverobj.getDriver());
		}
		//Assert.assertTrue(homePageElements.welcome_button.isDisplayed(), "Could not login successfully");
		// logger.info("Verified welcome button on the homepage");
	}



	public void logOut()  {
		if (homePageElements == null) {
			homePageElements = homePageObj.initElements(driverobj.getDriver());
		}
		homePageElements.signOutButton.click();
	}

}

