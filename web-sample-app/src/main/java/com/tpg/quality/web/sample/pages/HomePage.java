package com.tpg.quality.web.sample.pages;

import javax.inject.Inject;

import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

import com.tpg.quality.web.sample.or.HomePageObjects;
import com.tpg.quality.web.utility.custom_driver.Webdriver;

@Component
public class HomePage {

	// static Logger logger = Logger.getLogger(HomePage.class);
	@Inject
	private Webdriver driverobj;

	@Inject
	private HomePageObjects homePageObj;

	HomePageObjects homePageElements;

	public void verifyHomePage() {
		homePageElements = null;
		homePageElements = homePageObj.initElements(driverobj.getDriver());
		//Assert.assertTrue(homePageElements.welcome_button.isDisplayed(), "Could not login successfully");
		// logger.info("Verified welcome button on the homepage");
	}

	
	
	public void signOut() throws InterruptedException {
		if (homePageElements == null) {
			homePageElements = homePageObj.initElements(driverobj.getDriver());
		}
		Actions action = new Actions(driverobj.getDriver());
        action.moveToElement(homePageElements.yourAcc).build().perform();
        homePageElements.signOut.click();
        homePageElements.signOutButton.click();
	}
	
}

