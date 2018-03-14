package com.tpg.quality.web.utility.custom_driver;

import java.lang.reflect.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;
import com.tpg.quality.web.utility.MyInvocationHandler;

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
