package com.tpg.quality.web.sample.or;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;
import com.tpg.quality.web.utility.custom_annotation.FindBy;
import com.tpg.quality.web.utility.custom_pagefactory.CustomPageFactory;
import com.tpg.quality.web.utility.custom_webelements.Button;
import com.tpg.quality.web.utility.custom_webelements.TextField;

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

	@FindBy(tag = "id", value = "txtUsername")
	public TextField username;

	@FindBy(tag = "id", value = "txtPassword")
	public TextField password;

	@FindBy(tag = "id", value = "btnLogin")
	public Button login;
}
