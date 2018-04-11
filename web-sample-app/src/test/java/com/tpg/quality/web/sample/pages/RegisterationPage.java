package com.tpg.quality.web.sample.pages;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.sample.locators.RegisterationPageObjects;
import com.tpg.quality.web.webelements.Button;

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
		registerationPageElements.genderType.selectByValue(gender);

	}

	public void selectInterest(ArrayList<String> listOfInterest) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		List<Button> elems = registerationPageElements.interest;
		for(int i=0;i<elems.size();i++){
			if(listOfInterest.contains(elems.get(i).getAttribute("id"))){
				registerationPageElements.interest.get(i).click();
			}

		}

		// logger.info("Clicked login");
	}

	public void selectCourseType(String course) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		registerationPageElements.courseType.selectByVisibleText(course);
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

	public void invokePage(){
		registerationPageElements = null;
		registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());


	}

}
