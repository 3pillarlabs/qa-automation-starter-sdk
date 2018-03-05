package com.tpg.quality.web.sample.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tpg.quality.web.utility.custom_annotation.CustomElementLocatorFactory;
import com.tpg.quality.web.utility.custom_annotation.FindBy;
/**
 * 
 * @author satnam.malhotra
 *
 */
public class HomePageObjects {
	public HomePageObjects(WebDriver driver) {
		CustomElementLocatorFactory annotation = new CustomElementLocatorFactory(driver);
		PageFactory.initElements(annotation, this);
	}

	@FindBy(tag = "id", value = "welcome")
	public static WebElement welcome_button;

	@FindBy(tag = "xpath", value = "//a[contains(.,'Logout')]")
	public static WebElement logout;
}
