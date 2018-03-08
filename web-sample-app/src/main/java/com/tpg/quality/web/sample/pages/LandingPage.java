package com.tpg.quality.web.sample.pages;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.tpg.quality.web.sample.or.LandingPageObjects;
import com.tpg.quality.web.utility.custom_driver.Webdriver;

@Component
public class LandingPage {
	@Inject
	private Webdriver driverobj;
	@Inject
	private LandingPageObjects landingPageObj;

	LandingPageObjects landingPageElements;
	// static Logger logger = Logger.getLogger(LandingPage.class);

	public void openLandingPage(String url) {
		driverobj.getDriver().get(url);
		// logger.info("Opened the link " + url);
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
	}

	public void enterUserName() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.username.setText("Admin");
		// logger.info("Entered username");
	}

	public void enterPassword() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.password.setText("admin");
		// logger.info("Entered password");
	}

	public void clickLogin() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.login.click();
		// logger.info("Clicked login");
	}
}
