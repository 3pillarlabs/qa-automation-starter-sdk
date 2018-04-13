package com.tpg.quality.web.elementImpl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.tpg.quality.web.driver.Webdriver;
import com.tpg.quality.web.utility.ExtentTestManager;
import com.tpg.quality.web.webelements.TextField;

public class TextFieldImpl extends CustomElementImpl implements TextField {

	//private WebDriver driver = Webdriver.ThDriver.get();
	private WebDriverWait waitForElem = Webdriver.driverWait;

	public TextFieldImpl(WebElement element) {
		super(element);
	}

	@Override
	public void setText(String text) {
		WebElement element = getWrappedElement();
		boolean elementVisible = false;
		try{
			waitForElem.until(ExpectedConditions.visibilityOf(element));
			elementVisible = true;
		}
		catch (Exception e) {
			elementVisible = false;
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Element with value "+element.toString()+" is not visible");
		} 

		if(element.isEnabled() && elementVisible){
			super.sendKeys(text);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Entered text "+text+ "into field "+element.toString());
		} 
	}

}
