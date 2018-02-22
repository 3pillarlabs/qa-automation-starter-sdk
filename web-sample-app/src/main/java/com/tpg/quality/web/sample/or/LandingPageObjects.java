package com.tpg.quality.web.sample.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {

	public LandingPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	public static WebElement username;

	@FindBy(id = "txtPassword")
	public static WebElement password;

	@FindBy(id = "btnLogin")
	public static WebElement login;

}
