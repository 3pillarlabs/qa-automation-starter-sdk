package com.tpg.quality.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class CustomChrome {
	String location = System.getProperty("user.dir");
	private WebDriver driver;

	public WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", location + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		/*driver = (WebDriver) Proxy.newProxyInstance(RemoteWebDriver.class.getClassLoader(), new Class[] { WebDriver.class },
				new MyInvocationHandler(driver));*/
		return driver;
		}
}
