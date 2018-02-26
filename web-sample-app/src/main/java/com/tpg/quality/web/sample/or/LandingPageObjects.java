package com.tpg.quality.web.sample.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.tpg.quality.web.utility.CustomElementLocatorFactory;
import com.tpg.quality.web.utility.CustomFindBy;
/**
 * 
 * @author satnam.malhotra
 *
 */
public class LandingPageObjects {

	public LandingPageObjects(WebDriver driver) {
		CustomElementLocatorFactory annotation = new CustomElementLocatorFactory(driver);
		PageFactory.initElements(annotation, this);
	}

	@CustomFindBy(tag = "id", value = "txtUsername")
	public static WebElement username;

	@CustomFindBy(tag = "id", value = "txtPassword")
	public static WebElement password;

	@CustomFindBy(tag = "id", value = "btnLogin")
	public static WebElement login;

}
