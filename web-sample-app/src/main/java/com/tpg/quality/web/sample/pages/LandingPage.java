package com.tpg.quality.web.sample.pages;

import com.tpg.quality.web.sample.or.HomePageObjects;
import com.tpg.quality.web.sample.or.LandingPageObjects;
import com.tpg.quality.web.utility.InitDriver;

public class LandingPage extends InitDriver {

//	static Logger logger = Logger.getLogger(LandingPage.class);

	public static LandingPageObjects openLandingPage(String url) {
		getDriver().get(url);
//		logger.info("Opened the link " + url);
		return new LandingPageObjects(getDriver());
	}

	public static void enterUserName() {
		LandingPageObjects.username.sendKeys("Admin");
//		logger.info("Entered username");
	}

	public static void enterPassword() {
		LandingPageObjects.password.sendKeys("admin");
//		logger.info("Entered password");
	}

	public static HomePageObjects clickLogin() {
		LandingPageObjects.login.click();
//		logger.info("Clicked login");
		return new HomePageObjects(getDriver());
	}

}
