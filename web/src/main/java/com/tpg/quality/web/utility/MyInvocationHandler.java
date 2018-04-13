package com.tpg.quality.web.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author payal.gogia, satnam.malhotra
 *
 */
public class MyInvocationHandler implements InvocationHandler {
	private WebDriver driver;
	private WebDriverWait waitForElem;
	Object obj;
	public MyInvocationHandler(Object o) {
		driver = (WebDriver)o;
		Properties prop = readPropertiesFile();
		int explicitWait = Integer.parseInt(prop.getProperty("ExplicitWait"));
		waitForElem = new WebDriverWait(driver, explicitWait);

	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			if (method.getName().equals("findElement")){

				String elem = args[0].toString().split(":")[1].trim();
				String locatorType = args[0].toString().split(":")[0].trim().split("By.")[1];

				switch (locatorType) {
				case "id":
					waitForElem.until(ExpectedConditions.presenceOfElementLocated(By.id(elem)));
					waitForElem.until(ExpectedConditions.visibilityOfElementLocated(By.id(elem)));
					break;
				case "xpath":
					waitForElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elem)));
					waitForElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elem)));
					break;
				case "cssSelector":
					waitForElem.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elem)));
					waitForElem.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elem)));
					break;
				case "className":
					waitForElem.until(ExpectedConditions.presenceOfElementLocated(By.className(elem)));
					waitForElem.until(ExpectedConditions.visibilityOfElementLocated(By.className(elem)));
					break;
				case "linkText":
					waitForElem.until(ExpectedConditions.presenceOfElementLocated(By.linkText(elem)));	
					waitForElem.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elem)));
					break;
				case "name":
					waitForElem.until(ExpectedConditions.presenceOfElementLocated(By.name(elem)));	
					waitForElem.until(ExpectedConditions.visibilityOfElementLocated(By.name(elem)));
					break;
				default:
					break;
				}
			}

			return method.invoke(driver, args);
			//findElement in proxy of element
		} 
		catch (Exception e) 
		{
			throw e.getCause();
		}
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
