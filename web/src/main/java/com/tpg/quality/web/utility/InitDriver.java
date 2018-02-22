package com.tpg.quality.web.utility;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;


public class InitDriver {
	public final static ThreadLocal<WebDriver> ThDriver = new ThreadLocal<WebDriver>();
	public static String OS;
	protected static String browserType;
	protected static WebDriverWait wait;

	public static WebDriver getDriver() {
		String location = System.getProperty("user.dir");
		OS = System.getProperty("os.name").toLowerCase();
		WebDriver driver = ThDriver.get();
		if (driver == null) {
			if (browserType.equals("firefox")) {
				if (isWindows()) {
					System.setProperty("webdriver.gecko.driver", location + "//resources//geckodriver.exe");
				} else if (isMac()) {
					System.setProperty("webdriver.gecko.driver", location + "//resources//geckodriver");
				} else if (isLinux()) {
					System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
				}
				driver = new FirefoxDriver();
				driver = (WebDriver) Proxy.newProxyInstance(WebDriver.class.getClassLoader(),
						new Class[] { WebDriver.class }, new MyInvocationHandler(driver));
				ThDriver.set(driver);
			}

			if (browserType.equals("chrome")) {
				if (isWindows()) {
					System.setProperty("webdriver.chrome.driver",
							location + "//resources//chromedriver.exe");
				} else if (isMac()) {
					System.setProperty("webdriver.chrome.driver", location + "//resources//chromedriver");
				} else if (isLinux()) {
					System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
				}
				driver = new ChromeDriver();
				driver = (WebDriver) Proxy.newProxyInstance(WebDriver.class.getClassLoader(),
						new Class[] { WebDriver.class }, new MyInvocationHandler(driver));
				ThDriver.set(driver);
			}
			if (browserType.equals("ie")) {
				if (isWindows()) {
					System.setProperty("webdriver.ie.driver", location + "//src//resources//IEDriver.exe");
				} else if (isMac()) {
					System.setProperty("webdriver.ie.driver", location + "//src//resources//IEDriver");
				} else if (isLinux()) {
					System.setProperty("webdriver.ie.driver", "/usr/bin/IEDriver");
				}
				driver = new InternetExplorerDriver();
				driver = (WebDriver) Proxy.newProxyInstance(WebDriver.class.getClassLoader(),
						new Class[] { WebDriver.class }, new MyInvocationHandler(driver));
				ThDriver.set(driver);
			}
			ThDriver.get().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
			wait = new WebDriverWait(driver, 30);
		}
		return ThDriver.get();
	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isLinux() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}

	@Parameters("browser")
	public static void setupDriver(String browser) {
		browserType = browser;
	}

	public void quitDriver() throws InterruptedException, IOException {
		getDriver().quit();
		ThDriver.set(null);
	}

}
