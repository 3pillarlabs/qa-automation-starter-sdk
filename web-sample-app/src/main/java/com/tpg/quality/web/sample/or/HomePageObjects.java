package com.tpg.quality.web.sample.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	public HomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "welcome")
	public static WebElement welcome_button;

	@FindBy(xpath = "//a[contains(.,'Logout')]")
	public static WebElement logout;
}
