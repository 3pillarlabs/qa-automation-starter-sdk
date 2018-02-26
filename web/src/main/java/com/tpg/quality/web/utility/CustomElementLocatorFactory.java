package com.tpg.quality.web.utility;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * 
 * @author satnam.malhotra
 *
 */
public class CustomElementLocatorFactory implements ElementLocatorFactory {
	private final SearchContext searchContext;
	
	 public CustomElementLocatorFactory(SearchContext searchContext) {
	        this.searchContext = searchContext;
	    }

	@Override
	public ElementLocator createLocator(Field field) {
		return new CustomElementLocator(searchContext, new CustomAnnotation(field));
	}

}
