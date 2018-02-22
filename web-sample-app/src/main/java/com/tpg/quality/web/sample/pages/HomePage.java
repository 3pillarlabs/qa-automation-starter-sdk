package com.tpg.quality.web.sample.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.tpg.quality.web.sample.or.HomePageObjects;
import com.tpg.quality.web.utility.InitDriver;

public class HomePage extends InitDriver {

//	static Logger logger = Logger.getLogger(HomePage.class);

	public static void verifyHomePage() {
		Assert.assertTrue(HomePageObjects.welcome_button.isDisplayed(), "Could not login successfully");
//		logger.info("Verified welcome button on the homepage");
	}

	public static void clickWelcome() {
		HomePageObjects.welcome_button.click();
//		logger.info("Clicked on welcome button");
	}

	public static void clickLogout() {
		wait.until(ExpectedConditions.visibilityOf(HomePageObjects.logout));
		HomePageObjects.logout.click();
//		logger.info("Clicked on logout button");
	}

}
