package com.tpg.quality.web.sample.pages;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.relevantcodes.extentreports.LogStatus;
import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.sample.locators.RegisterationPageObjects;
import com.tpg.quality.web.utility.ExtentTestManager;
import com.tpg.quality.web.webelements.Button;

@Component
public class RegisterationPage {
	@Inject
	private Webdriver driverobj;
	@Inject
	private RegisterationPageObjects registerationPageObj;

	RegisterationPageObjects registerationPageElements = null;



	public void enterFirstname(String firstName) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter value "+firstName+" as FirstName");
		registerationPageElements.firstName.setText(firstName);
	
	}

	public void enterLastname(String lastname) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter value "+lastname+" as LastName");
		registerationPageElements.lastName.setText(lastname);
		
	}

	public void enterEmail(String email) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter value "+email+" as Email");
		registerationPageElements.email.setText(email);
	
	}

	public void enterUsername(String username) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter value "+username+" as UserName");
		registerationPageElements.userName.setText(username);
	
	}

	public void enterPassword(String password) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Enter value "+password+" as Password");
		registerationPageElements.password.setText(password);
		
	}

	public void selectGender(String gender) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Select "+gender+" as Gender");
		registerationPageElements.genderType.selectByValue(gender);

	}

	public void selectInterest(ArrayList<String> listOfInterest) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Check "+listOfInterest+" as User's interest area");
		List<Button> elems = registerationPageElements.interest;
		for(int i=0;i<elems.size();i++){
			if(listOfInterest.contains(elems.get(i).getAttribute("id"))){
				registerationPageElements.interest.get(i).click();
			}

		}

	}

	public void selectCourseType(String course) {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Select "+course+" as CourseType");
		registerationPageElements.courseType.selectByVisibleText(course);
		// logger.info("Clicked login");
	}

	public void clickSubmit() {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Going to click on Submit button");
		registerationPageElements.submit.click();
		
	}

	public void clickReset() {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Going to click on Reset button");
		registerationPageElements.reset.click();
		
	}

	public void clickLoginLink() {
		if (registerationPageElements == null) {
			registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO, "Going to click on Login button");
		registerationPageElements.loginLink.click();
		
	}

	public void invokePage(){
		registerationPageElements = null;
		registerationPageElements = registerationPageObj.initElements(driverobj.getDriver());


	}

}
