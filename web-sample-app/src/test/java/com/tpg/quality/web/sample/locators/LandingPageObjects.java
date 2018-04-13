package com.tpg.quality.web.sample.locators;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.tpg.quality.web.annotation.FindBy;
import com.tpg.quality.web.pagefactory.CustomPageFactory;
import com.tpg.quality.web.webelements.Button;
import com.tpg.quality.web.webelements.TextField;

/**
 * 
 * @author satnam.malhotra
 *
 */
@Component
public class LandingPageObjects {

	public LandingPageObjects initElements(WebDriver driver) {
		return CustomPageFactory.initElements(driver, LandingPageObjects.class);
	}

	@FindBy(tag = "xpath", value = "//a[contains(text(),'Register Here')]")
	public Button registerationLink;

	@FindBy(tag = "id", value = "submitButton")
	public Button submit;

	@FindBy(tag = "id", value = "resetButton")
	public Button reset;

	@FindBy(tag = "id", value = "username")
	public TextField login;

	@FindBy(tag = "id", value = "password")
	public TextField password;
}
