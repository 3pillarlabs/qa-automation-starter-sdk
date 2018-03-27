package com.tpg.quality.web.sample.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.tpg.quality.web.annotation.FindBy;
import com.tpg.quality.web.pagefactory.CustomPageFactory;

/**
 * 
 * @author satnam.malhotra
 *
 */
@Component
public class RegisteredPageObjects {

	public RegisteredPageObjects initElements(WebDriver driver) {
		return CustomPageFactory.initElements(driver, RegisteredPageObjects.class);
	}

	@FindBy(tag = "id", value = "successMsg")
	public WebElement successMsg;

	@FindBy(tag = "xpath", value = "(//a[contains(text(),'Login')])")
	public WebElement loginPagelink;

}
