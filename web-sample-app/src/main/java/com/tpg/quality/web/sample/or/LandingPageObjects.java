package com.tpg.quality.web.sample.or;

import org.openqa.selenium.WebDriver;

import com.tpg.quality.web.utility.custom_annotation.FindBy;
import com.tpg.quality.web.utility.custom_pagefactory.CustomPageFactory;
import com.tpg.quality.web.utility.custom_webelements.Button;
import com.tpg.quality.web.utility.custom_webelements.TextField;
/**
 * 
 * @author satnam.malhotra
 *
 */
public class LandingPageObjects {

	public static LandingPageObjects initElements(WebDriver driver) {
		return CustomPageFactory.initElements(driver, LandingPageObjects.class);
	}

	@FindBy(tag = "id", value = "txtUsername")
	public static TextField username;

	@FindBy(tag = "id", value = "txtPassword")
	public static TextField password;

	@FindBy(tag = "id", value = "btnLogin")
	public static Button login;

}
