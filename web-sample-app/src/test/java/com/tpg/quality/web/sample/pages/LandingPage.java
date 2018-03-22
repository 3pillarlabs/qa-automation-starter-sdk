package com.tpg.quality.web.sample.pages;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.sample.or.LandingPageObjects;

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
		landingPageElements = null;
		// logger.info("Opened the link " + url);
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
	}

	public void clickPSF() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.psf.click();
		// logger.info("Entered username");
	}

	public void userSignIn() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.usersignIn.click();
		// logger.info("Entered password");
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
	
	public void signIn() {
		if (landingPageElements == null) {
			landingPageElements = landingPageObj.initElements(driverobj.getDriver());
		}
		landingPageElements.signIn.click();
		// logger.info("Entered password");
	}
	
	
	

}
