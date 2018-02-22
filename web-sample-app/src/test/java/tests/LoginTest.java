package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tpg.quality.web.sample.pages.HomePage;
import com.tpg.quality.web.sample.pages.LandingPage;
import com.tpg.quality.web.utility.MainClass;
import com.tpg.quality.web.utility.TestReports;


@Listeners(value = TestReports.class)
public class LoginTest extends MainClass {
	

	@Test(description = "Login to orange HRM and verify")
	@TestData(testId = 1)
	public void verifyLogin() throws InterruptedException {
		LandingPage.openLandingPage("http://opensource.demo.orangehrmlive.com/");
		LandingPage.enterUserName();
		LandingPage.enterPassword();
		LandingPage.clickLogin();
		HomePage.verifyHomePage();
	}

	@Test(description = "Login to orange HRM, logout and verify")
	@TestData(testId = 2)
	public void verifyLogout() throws InterruptedException {
		LandingPage.openLandingPage("http://opensource.demo.orangehrmlive.com/");
		LandingPage.enterUserName();
		LandingPage.enterPassword();
		LandingPage.clickLogin();
		HomePage.clickWelcome();
		HomePage.clickLogout();
	}
}
