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

	@Test(description = "Login to python site ")
	public void verifyLogin() {
		landingPageobj.openLandingPage("http://www.python.org/");
		landingPageobj.clickPSF();
		landingPageobj.userSignIn();
		landingPageobj.enterUsername("internal_project");
		landingPageobj.enterPassword("3pillar@123");
		landingPageobj.signIn();
		//homePageobj.verifyHomePage();
	}

	@Test(description = "Logout from python site")
	public void verifyLogout() throws InterruptedException  {
		landingPageobj.openLandingPage("http://www.python.org/");
		landingPageobj.clickPSF();
		landingPageobj.userSignIn();
		landingPageobj.enterUsername("internal_project");
		landingPageobj.enterPassword("3pillar@123");
		landingPageobj.signIn();
		homePageobj.signOut();
		
	}
	
	
	
	
		
	
}
