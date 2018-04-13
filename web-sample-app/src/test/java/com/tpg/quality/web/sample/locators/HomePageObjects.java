package com.tpg.quality.web.sample.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.tpg.quality.web.annotation.FindBy;
import com.tpg.quality.web.pagefactory.CustomPageFactory;
import com.tpg.quality.web.webelements.Button;

@Component
public class HomePageObjects {

	public HomePageObjects initElements(WebDriver driver) {
		return CustomPageFactory.initElements(driver, HomePageObjects.class);
	}

	@FindBy(tag = "id", value = "loginMsg")
	public WebElement loginMsg;

	@FindBy(tag = "xpath", value = "//a[contains(text(),'LogOut')]")
	public Button signOutButton;

	@FindBy(tag = "xpath", value = "//a[contains(text(),'Your account')]")
	public Button yourAcc;
}
