package com.tpg.quality.web.utility.custom_webelements;

import org.openqa.selenium.WebElement;

public class TextFieldImpl extends CustomElementImpl implements TextField {

	public TextFieldImpl(WebElement element) {
		super(element);
	}

	@Override
	public void sendKeys(String text) {
		WebElement element = getWrappedElement();
		element.sendKeys(text);
	}

	
}
