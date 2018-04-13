package com.tpg.quality.web.webelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

/**
 * Custom element interface extending other interfaces (WebElement,
 * WrapsElement, Locatable)	
 * 
 * @author satnam.malhotra
 *
 */

public interface CustomElement extends WebElement, WrapsElement, Locatable {

	boolean elementWired();

}
