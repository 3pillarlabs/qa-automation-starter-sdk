package com.tpg.quality.web.webelements;

import java.util.ArrayList;

public interface Button extends CustomElement {

	void click();
	void selectByValue(String selection);
	void select(ArrayList<String> selection);
	void selectByVisibleText(String text);

}
