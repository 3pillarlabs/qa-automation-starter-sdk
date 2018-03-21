package com.tpg.quality.web.driver;

import java.lang.reflect.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import com.tpg.quality.web.utility.MyInvocationHandler;

@Component
public class CustomFirefox {

	String location = System.getProperty("user.dir");
	private WebDriver driver;

	public WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", location + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver = (WebDriver) Proxy.newProxyInstance(WebDriver.class.getClassLoader(), new Class[] { WebDriver.class },
				new MyInvocationHandler(driver));
		return driver;
	}
}
