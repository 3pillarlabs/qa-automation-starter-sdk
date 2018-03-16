package com.tpg.quality.web.sample.or;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.tpg.quality.web.annotation.FindBy;
import com.tpg.quality.web.pagefactory.CustomPageFactory;
import com.tpg.quality.web.webelements.Button;

@Component
public class HomePageObjects {

	public HomePageObjects initElements(WebDriver driver) {
		return CustomPageFactory.initElements(driver, HomePageObjects.class);
	}

	@FindBy(tag = "xpath", value = "//a[contains(.,'Sign out')]")
	public Button signOut;
	
	@FindBy(tag = "xpath", value = "//button[contains(text(),'Sign Out')]")
	public Button signOutButton;
	
	@FindBy(tag = "xpath", value = "//a[contains(text(),'Your account')]")
	public Button yourAcc;
}
