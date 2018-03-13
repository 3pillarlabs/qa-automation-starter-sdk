package com.tpg.quality.web.utility.custom_driver;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class Webdriver {

	@Inject
	private CustomFirefox firefox_driver;
	@Inject
	private CustomChrome chrome_driver;
	@Inject
	private CustomIE ie_driver;
	
	private WebDriver driver;
	public String browser;
	public final static ThreadLocal<WebDriver> ThDriver = new ThreadLocal<WebDriver>();
	public WebDriverWait wait;

	public WebDriver getDriver() {
		if (ThDriver.get() == null) {
			switch (browser) {
			case "firefox":
				driver = firefox_driver.getFirefoxDriver();
				break;
			case "chrome":
				driver = chrome_driver.getChromeDriver();
				break;
			case "ie":
				driver = ie_driver.getIEDriver();
				break;
			}
			ThDriver.set(driver);
			//ThDriver.get().manage().window().fullscreen();
			ThDriver.get().manage().deleteAllCookies();
			ThDriver.get().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
			wait = new WebDriverWait(ThDriver.get(), 60);
			
		}
		return ThDriver.get();
	}

	public void closeDriver() {
		ThDriver.get().quit();
		ThDriver.set(null);
	}

	

}
