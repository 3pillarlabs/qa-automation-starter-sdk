package com.tpg.quality.web.webelements;

@ImplementedBy(TextFieldImpl.class)
public interface TextField extends CustomElement {

	void setText(String text);

}
