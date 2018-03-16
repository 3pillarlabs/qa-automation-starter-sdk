package com.tpg.quality.web.sample.or;

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

	@FindBy(tag = "xpath", value = "//a[contains(text(),'PSF')]")
	public Button psf;

	@FindBy(tag = "xpath", value = "(//a[contains(.,'Sign In')])[1]")
	public Button usersignIn;

	@FindBy(tag = "id", value = "id_login")
	public TextField login;
	
	@FindBy(tag = "id", value = "id_password")
	public TextField password;
	
	@FindBy(tag = "xpath", value = "(//button[contains(.,'Sign In')])")
	public Button signIn;
}
