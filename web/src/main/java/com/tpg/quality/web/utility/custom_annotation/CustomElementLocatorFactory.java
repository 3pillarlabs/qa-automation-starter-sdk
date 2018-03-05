package com.tpg.quality.web.utility.custom_annotation;

import java.lang.reflect.Field;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Custom class implementing default ElementLoctorFactory interface and its
 * createLocator() method is being overridden.
 * 
 * @author satnam.malhotra
 *
 */
public class CustomElementLocatorFactory implements ElementLocatorFactory {
	private final SearchContext searchContext;

	public CustomElementLocatorFactory(SearchContext searchContext) {
		this.searchContext = searchContext;
	}

	// Changed the return type to CustomElementLocator from ElementLocator
	@Override
	public CustomElementLocator createLocator(Field field) {
		return new CustomElementLocator(searchContext, new CustomAnnotation(field));
	}

}
