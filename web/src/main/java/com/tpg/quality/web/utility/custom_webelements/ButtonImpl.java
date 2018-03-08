package com.tpg.quality.web.utility.custom_webelements;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class ButtonImpl extends CustomElementImpl implements Button {

	public ButtonImpl(WebElement element) {
		super(element);
	}

	@Override
	public void click() {
		try {
			WebElement element = getWrappedElement();
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
			} else {
				// the element is not displayed or is not clickable
			}

		} catch (ElementNotSelectableException e) {
			// add logger here Button is not clickable.
			e.printStackTrace();
			e.toString();
			e.getMessage();
		}
	}

	@Override
	public void submit() {
		try {
			WebElement element = getWrappedElement();
			if (element.isDisplayed() && element.isEnabled()) {
				element.submit();
			} else {
				// the element is not displayed or is not clickable
			}

		} catch (ElementNotSelectableException e) {
			// add logger here Button is not clickable.
			e.printStackTrace();
			e.toString();
			e.getMessage();
		}
	}

	@Override
	public boolean isSelected() {
		try {
			WebElement element = getWrappedElement();
			if (element.isDisplayed()) {
				return element.isSelected();
			} else {
				return false;
			}
		} catch (ElementNotVisibleException env) {
			// check if we have to throw exception from here to main test case
			env.toString();
			return false;
		} catch (NoSuchElementException nse) {
			return false;
		} catch (StaleElementReferenceException ser) {
			return false;
		} catch (TimeoutException timeoutExc) {
			return false;
		} catch (WebDriverException exc) {
			return false;
		}
	}
}
