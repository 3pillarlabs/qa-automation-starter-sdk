package com.tpg.quality.web.utility.custom_webelements;

@ImplementedBy(ButtonImpl.class)
public interface Button extends CustomElement {

	void click();

}
