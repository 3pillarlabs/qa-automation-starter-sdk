package com.tpg.quality.web.webelements;

@ImplementedBy(ButtonImpl.class)
public interface Button extends CustomElement {

	void click();

}
