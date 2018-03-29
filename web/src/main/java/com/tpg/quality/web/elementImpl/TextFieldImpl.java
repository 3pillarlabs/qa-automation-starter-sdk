package com.tpg.quality.web.elementImpl;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.tpg.quality.web.webelements.TextField;

public class TextFieldImpl extends CustomElementImpl implements TextField {

	public TextFieldImpl(WebElement element) {
		super(element);
	}

	@Override
	public void setText(String text) {
		WebElement element = getWrappedElement();
		try {
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(text);
			}
		} catch (ElementNotVisibleException env) {
			// check if we have to throw exception from here to main test case
			env.toString();
		} catch (NoSuchElementException nse) {
		} catch (StaleElementReferenceException ser) {
		} catch (TimeoutException timeoutExc) {
		} catch (WebDriverException exc) {

		}
	}
}
