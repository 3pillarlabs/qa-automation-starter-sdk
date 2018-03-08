package com.tpg.quality.web.sample.or;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;
import com.tpg.quality.web.utility.custom_annotation.FindBy;
import com.tpg.quality.web.utility.custom_pagefactory.CustomPageFactory;
import com.tpg.quality.web.utility.custom_webelements.Button;

@Component
public class HomePageObjects {

	public HomePageObjects initElements(WebDriver driver) {
		return CustomPageFactory.initElements(driver, HomePageObjects.class);
	}

	@FindBy(tag = "id", value = "welcome")
	public Button welcome_button;

	@FindBy(tag = "xpath", value = "//a[contains(.,'Logout')]")
	public Button logout;
}
