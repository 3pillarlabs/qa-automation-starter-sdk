package com.tpg.quality.web.utility.custom_webelements;

@ImplementedBy(TextFieldImpl.class)
public interface TextField extends CustomElement {

	void setText(String text);

}
