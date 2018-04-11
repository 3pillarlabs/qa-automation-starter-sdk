package com.tpg.quality.web.sample.tests;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.testng.annotations.Test;

import com.tpg.quality.web.sample.pages.HomePage;
import com.tpg.quality.web.sample.pages.LandingPage;
import com.tpg.quality.web.sample.pages.RegisterationPage;
import com.tpg.quality.web.sample.pages.RegisteredPage;

@EnableAutoConfiguration
public class LoginTest2 extends BaseTest {
	@Inject
	private LandingPage landingPageobj;
	@Inject
	private HomePage homePageobj;
	@Inject
	private RegisterationPage registerationPageobj;
	@Inject
	private RegisteredPage registeredPageobj;



	@Test(description = "Register and login with same user ", priority=2)
	public void registerAndLoginUser() {
		invokePages();
		landingPageobj.invokePage();
		landingPageobj.openLandingPage("http://localhost:8080/welcome");
		landingPageobj.clickRegiserLink();
		registerationPageobj.enterFirstname("qatest");
		registerationPageobj.enterLastname("qatest");
		registerationPageobj.enterEmail("qatest@test.com");
		registerationPageobj.enterUsername("qanewuser1");
		registerationPageobj.enterPassword("qanewuser1");
		registerationPageobj.selectGender("male");
		ArrayList<String> options = new ArrayList<>(Arrays.asList("BigData", "SAP", "ERP"));
		registerationPageobj.selectInterest(options);
		registerationPageobj.selectCourseType("Professional");
		registerationPageobj.clickSubmit();
		registeredPageobj.clickLoginLink();
		landingPageobj.enterUsername("qanewuser1");
		landingPageobj.enterPassword("qanewuser1");
		landingPageobj.clickLogIn();
		homePageobj.verifyHomePage();
		homePageobj.logOut();
	}
	public void invokePages(){
		landingPageobj.invokePage();
		registerationPageobj.invokePage();
		registeredPageobj.invokePage();
		homePageobj.invokePage();

	}



}
