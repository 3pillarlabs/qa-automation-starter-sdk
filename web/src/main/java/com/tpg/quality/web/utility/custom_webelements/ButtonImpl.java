package com.tpg.quality.web.utility.custom_webelements;

import org.openqa.selenium.WebElement;

public class ButtonImpl extends CustomElementImpl implements Button {

	public ButtonImpl(WebElement element) {
		super(element);
	}

	@Override
	public void click() {
		WebElement element = getWrappedElement();
		element.click();
	}
}
