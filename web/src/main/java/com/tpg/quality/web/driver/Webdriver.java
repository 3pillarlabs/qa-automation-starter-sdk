package com.tpg.quality.web.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
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
	private int implicitWait;
	private int explicitWait;
	public static WebDriverWait driverWait;



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
			default:
				break;
			}
			ThDriver.set(driver);
			//ThDriver.get().manage().window().fullscreen();
			Properties prop = readPropertiesFile();
			implicitWait = Integer.parseInt(prop.getProperty("ImplicitWait"));
			explicitWait = Integer.parseInt(prop.getProperty("ExplicitWait"));
			ThDriver.get().manage().timeouts().implicitlyWait(implicitWait, TimeUnit.MILLISECONDS);
			driverWait = new WebDriverWait(ThDriver.get(), explicitWait);
		}
		return ThDriver.get();
	}

	public void closeDriver() {
		driver.close();
		ThDriver.get().quit();
		driver.quit();
		driver = null;
		ThDriver.set(null);
		/*try {
			Runtime.getRuntime().exec("TASKKILL /F /IM chromedriver.exe /T");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public Properties readPropertiesFile(){

		try{
			String propertyFileLoc = System.getProperty("user.dir") + "\\src\\test\\resources\\ConfigProperties";
			InputStream in = new FileInputStream(propertyFileLoc);
			Properties prop = new Properties();
			prop.load(in);
			return prop;
		}
		catch (IOException e){
			e.printStackTrace();
			return null;
		}


	}





}
