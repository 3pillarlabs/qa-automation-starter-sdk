package com.tpg.quality.web.sample.pages;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.sample.locators.RegisterationPageObjects;

@Component
public class RegisterationPage {
	@Inject
	private Webdriver driverobj;
	@Inject
	private RegisterationPageObjects registerationPageObj;

	RegisterationPageObjects registerationPageElements = null;


	// static Logger logger = Logger.getLogger(LandingPage.class);

	public void enterFirstname(String firstName) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		registerationPageElements.firstName.setText(firstName);
		// logger.info("Clicked login");
	}

	public void enterLastname(String lastname) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		registerationPageElements.lastName.setText(lastname);
		// logger.info("Clicked login");
	}

	public void enterEmail(String email) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		registerationPageElements.email.setText(email);
		// logger.info("Clicked login");
	}

	public void enterUsername(String username) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		registerationPageElements.userName.setText(username);
		// logger.info("Clicked login");
	}

	public void enterPassword(String password) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		registerationPageElements.password.setText(password);
		// logger.info("Clicked login");
	}

	public void selectGender(String gender) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		Select oSelect = new Select(registerationPageElements.genderType);
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			if(sValue.equals(gender)){
				oSelect.selectByValue(sValue);
				break;
			}
		}

		// logger.info("Clicked login");
	}

	public void selectInterest(ArrayList<String> userInterest) {
		ArrayList<String> defaultInterestList = null;
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		Select oSelect = new Select(registerationPageElements.interest);
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		for(int i =0; i<iSize ; i++){
			defaultInterestList.add(elementCount.get(i).getText());
		}
		for(int i=0; i<userInterest.size(); i++){
			if(defaultInterestList.contains(userInterest.get(i))){
				oSelect.selectByVisibleText(userInterest.get(i));

			}
		}
		// logger.info("Clicked login");
	}

	public void selectCourseType(String course) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		Select oSelect = new Select(registerationPageElements.courseType);
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		for(int i =0; i<iSize ; i++){
			if(elementCount.get(i).getText().equals(course)){
				oSelect.selectByVisibleText(course);       		
			}
		}
		// logger.info("Clicked login");
	}

	public void clickSubmit() {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		registerationPageElements.submit.click();
		// logger.info("Entered password");
	}

	public void clickReset() {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		registerationPageElements.reset.click();
		// logger.info("Entered password");
	}

	public void clickLoginLink() {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		registerationPageElements.loginLink.click();
		// logger.info("Entered username");
	}

}
