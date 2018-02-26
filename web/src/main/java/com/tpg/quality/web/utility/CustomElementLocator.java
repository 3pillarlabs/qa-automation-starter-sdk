package com.tpg.quality.web.utility;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;
/**
 * 
 * @author satnam.malhotra
 *
 */
public class CustomElementLocator implements ElementLocator {

	private final SearchContext searchContext;
	private final boolean elementFromCache;
	private final By by;
	private WebElement cachedElement;
	private List<WebElement> cachedElementList;

	public CustomElementLocator(SearchContext searchContext, AbstractAnnotations annotations) {
		this.searchContext = searchContext;
		this.elementFromCache = annotations.isLookupCached();
		this.by = annotations.buildBy();
	}

	@Override
	public WebElement findElement() {
		if (cachedElement != null && elementFromCache) {
			return cachedElement;
		}
		WebElement element = searchContext.findElement(by);
		if (elementFromCache) {
			cachedElement = element;
		}
		return element;
	}

	@Override
	public List<WebElement> findElements() {
		if (cachedElementList != null && elementFromCache) {
			return cachedElementList;
		}
		List<WebElement> elements = searchContext.findElements(by);
		if (elementFromCache) {
			cachedElementList = elements;
		}
		return elements;

	}
}
