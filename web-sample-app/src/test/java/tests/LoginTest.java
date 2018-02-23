package tests;

import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.tpg.quality.web.sample.pages.HomePage;
import com.tpg.quality.web.sample.pages.LandingPage;
import com.tpg.quality.web.utility.MainClass;
import com.tpg.quality.web.utility.TestReports;
//package com.tpg.qas.web.main;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

//import com.tpg.qas.web.pages.Login;

@ComponentScan(basePackages="com.tpg")
@SpringBootApplication
//@Listeners(value = TestReports.class)

public class LoginTest  extends AbstractTestNGSpringContextTests implements CommandLineRunner{

	@Inject
	private LandingPage landingPage;

	/*@Inject
	public void LoginTest(LandingPage landingPage){
		this.landingPage = landingPage;
	}*/

	public static void main(String[] args) {
		new SpringApplicationBuilder(LoginTest.class).web(WebApplicationType.SERVLET).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("####inside run method");
		TestNG testngRunner = new TestNG();
		landingPage.printMyStatement();
		//To run tests in Parallel mode
		// testngRunner.setParallel(XmlSuite.ParallelMode.METHODS);
		//Provide the list of test classes
		testngRunner.setTestClasses(new Class[]{
				LoginTest.class} );
		//Run tests
		testngRunner.run();

	}
	

	@Test
	public void printHello(){
		System.out.println("###");
		landingPage.printMyStatement();
		System.out.println("$$$$$$$$$");

	}	


}


/*public class LoginTest extends MainClass {


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

 */

