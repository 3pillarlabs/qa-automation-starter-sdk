package com.tpg.quality.web.sample.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.tpg.quality.web.driver.Webdriver;

@ComponentScan(basePackages = "com.tpg")
@SpringBootApplication
public class BaseTest extends AbstractTestNGSpringContextTests  {
	@Inject
	private Webdriver driver;

	public static void main(String[] args) {

		XmlSuite suite = new XmlSuite();
		suite.setName("MyTestSuite");
		Map<String, String> mapObj = new HashMap<String, String>();
		mapObj.put("browser", "chrome");
		suite.setParameters(mapObj);
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.tpg.quality.web.sample.tests.LoginTest"));
		XmlTest test = new XmlTest(suite);
		test.setName("MyTests");
		test.setXmlClasses(classes);
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG testngRunner = new TestNG();
		testngRunner.setXmlSuites(suites);
		testngRunner.run();

	}

	@BeforeClass
	@Parameters("browser")
	public void setBrowser(@Optional("chrome") String browser) {
		driver.browser = browser;

	}

	@AfterClass
	public void quitBrowser() {
		driver.closeDriver();

	}
}
