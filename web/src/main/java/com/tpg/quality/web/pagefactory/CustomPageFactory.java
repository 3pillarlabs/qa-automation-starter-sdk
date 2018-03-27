package com.tpg.quality.web.pagefactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tpg.quality.web.annotation.CustomElementLocatorFactory;

public class CustomPageFactory extends PageFactory {

	public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
		T page = instantiatePage(driver, pageClassToProxy);
		initElements(driver, page);
		return page;
	}

	public static void initElements(WebDriver driver, Object page) {
		final WebDriver driverRef = driver;
		// Added custom field decorator here and changed the
		// DefaultElementLocatorFactory to CustomElementLocatorFactory
		initElements(new CustomFieldDecorator(new CustomElementLocatorFactory(driverRef)), page);
	}

	private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) {
		try {
			try {
				Constructor<T> page = pageClassToProxy.getConstructor(WebDriver.class);
				return page.newInstance(driver);
			} catch (NoSuchMethodException e) {
				return pageClassToProxy.newInstance();
			}
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
