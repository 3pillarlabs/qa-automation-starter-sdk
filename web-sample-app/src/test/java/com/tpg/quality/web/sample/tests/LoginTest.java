package com.tpg.quality.web.sample.tests;

import javax.inject.Inject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.testng.annotations.Test;
import com.tpg.quality.web.sample.pages.HomePage;
import com.tpg.quality.web.sample.pages.LandingPage;

@EnableAutoConfiguration
public class LoginTest extends BaseTest {
	@Inject
	private LandingPage landingPageobj;
	@Inject
	private HomePage homePageobj;

	@Test(description = "Login to orange HRM and verify")
	public void verifyLogin() {
		landingPageobj.openLandingPage("http://opensource.demo.orangehrmlive.com/");
		landingPageobj.enterUserName();
		landingPageobj.enterPassword();
		landingPageobj.clickLogin();
		homePageobj.verifyHomePage();
	}

	@Test(description = "Login to orange HRM, logout and verify")
	public void verifyLogout() throws InterruptedException {
		landingPageobj.openLandingPage("http://opensource.demo.orangehrmlive.com/");
		landingPageobj.enterUserName();
		landingPageobj.enterPassword();
		landingPageobj.clickLogin();
		homePageobj.clickWelcome();
		homePageobj.clickLogout();
	}
}
