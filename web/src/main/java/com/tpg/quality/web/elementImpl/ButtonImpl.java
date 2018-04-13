package com.tpg.quality.web.elementImpl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.utility.ExtentTestManager;
import com.tpg.quality.web.webelements.Button;

public class ButtonImpl extends CustomElementImpl implements Button {

	private WebDriverWait waitForElem = Webdriver.driverWait;

	public ButtonImpl(WebElement element) {

		super(element);

	}

	public void setElements(List<WebElement> elements) {
		super.setElements(elements);
	}

	@Override
	public void click() {
		WebElement element = null;
		try {
			element = getWrappedElement();
			boolean elementClickable = false;

			try{
				waitForElem.until(ExpectedConditions.elementToBeClickable(element));
				elementClickable = true;
			}
			catch (Exception e) {
				elementClickable = false;
				e.toString();
			} 
			if(element.isDisplayed() && element.isEnabled() && elementClickable){
				super.click();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked Element with value "+element.toString());
			} 

		} catch (Exception e ){
			// add logger here Button is not clickable.
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to click on Element with value "+element.toString());
		}
	}

	@Override
	public void submit() {
		WebElement element = null;
		try {
			element = getWrappedElement();
			boolean elementClickable = false;
			try{
				waitForElem.until(ExpectedConditions.elementToBeClickable(element));
				elementClickable = true;
			}
			catch (Exception e) {
				elementClickable = false;
				e.toString();
			} 
			if(element.isDisplayed() && element.isEnabled() && elementClickable){
				super.submit();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked Element with value "+element.toString());
			} 

		} catch (Exception e ){
			// add logger here Button is not clickable.
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Button with value " +element.toString()+" is not clickable");
		}
	}
	@Override
	public boolean isSelected() {
		WebElement element = null;
		try {
			element = getWrappedElement();
			if (element.isDisplayed()) {
				return element.isSelected();
			} else {
				return false;
			}
		} catch (Exception e) {
			// check if we have to throw exception from here to main test case
			e.toString();
			return false;
		}
	}

	@Override
	public void selectByValue(String selection) {
		// TODO Auto-generated method stub
		WebElement element = getWrappedElement();
		element.click();

		/*Select oSelect = new Select(element);
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			if(sValue.equals(selection)){
				oSelect.selectByValue(sValue);
				break;
			}
		}*/
	}

	@Override
	public void select(ArrayList<String> multipleSelection) {
		// TODO Auto-generated method stub
		WebElement element = getWrappedElement();
		ArrayList<String> defaultInterestList = null;

		Select oSelect = new Select(element);
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		for(int i =0; i<iSize ; i++){
			defaultInterestList.add(elementCount.get(i).getText());
		}
		for(int i=0; i<multipleSelection.size(); i++){
			if(defaultInterestList.contains(multipleSelection.get(i))){
				oSelect.selectByVisibleText(multipleSelection.get(i));

			}
		}

	}

	@Override
	public void selectByVisibleText(String text) {
		// TODO Auto-generated method stub
		WebElement element = getWrappedElement();
		Select oSelect = new Select(element);
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		for(int i =0; i<iSize ; i++){
			if(elementCount.get(i).getText().equals(text)){
				oSelect.selectByVisibleText(text);       		
			}
		}

	}
}  
