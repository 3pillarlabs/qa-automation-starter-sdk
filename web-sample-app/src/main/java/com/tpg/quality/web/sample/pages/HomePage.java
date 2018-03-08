package com.tpg.quality.web.sample.pages;

import javax.inject.Inject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;
import org.testng.Assert;
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
		homePageElements = homePageObj.initElements(driverobj.getDriver());
		Assert.assertTrue(homePageElements.welcome_button.isDisplayed(), "Could not login successfully");
		// logger.info("Verified welcome button on the homepage");
	}

	public void clickWelcome() {
		if (homePageElements == null) {
			homePageElements = homePageObj.initElements(driverobj.getDriver());
		}
		driverobj.wait.until(ExpectedConditions.visibilityOf(homePageElements.welcome_button));
		homePageElements.welcome_button.click();
		// logger.info("Clicked on welcome button");
	}

	public void clickLogout() {
		if (homePageElements == null) {
			homePageElements = homePageObj.initElements(driverobj.getDriver());
		}
		driverobj.wait.until(ExpectedConditions.elementToBeClickable(homePageElements.logout));
		homePageElements.logout.click();
		// logger.info("Clicked on logout button");
	}
}
