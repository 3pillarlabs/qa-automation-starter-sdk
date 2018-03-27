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
public class RegisterationPageObjects {

	public RegisterationPageObjects initElements(WebDriver driver) {
		return CustomPageFactory.initElements(driver, RegisterationPageObjects.class);
	}

	@FindBy(tag = "id", value = "firstname")
	public TextField firstName;

	@FindBy(tag = "id", value = "lastname")
	public TextField lastName;

	@FindBy(tag = "id", value = "emailid")
	public TextField email;

	@FindBy(tag = "id", value = "username")
	public TextField userName;

	@FindBy(tag = "id", value = "password")
	public TextField password;

	@FindBy(tag = "id", value = "genderType")
	public Button genderType;

	@FindBy(tag = "id", value = "interest")
	public Button interest;

	@FindBy(tag = "id", value = "courseType")
	public Button courseType;

	@FindBy(tag = "id", value = "submit")
	public Button submit;

	@FindBy(tag = "id", value = "reset")
	public Button reset;

	@FindBy(tag = "id", value = "//a[contains(text(),'Login Here')]")
	public Button loginLink;

}
