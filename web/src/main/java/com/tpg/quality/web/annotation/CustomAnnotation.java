package com.tpg.quality.web.annotation;

import java.lang.reflect.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;

import com.google.common.base.Preconditions;

/**
 * 
 * @author satnam.malhotra, payal.gogia
 *
 */
public class CustomAnnotation extends AbstractAnnotations {

	private final Field field;

	CustomAnnotation(Field field) {
		this.field = field;
	}

	@Override
	public By buildBy() {
		try {
			FindBy findBy = field.getAnnotation(FindBy.class);
			Preconditions.checkArgument(findBy != null, "Could not locate @FindBy annotation");
			String value = findBy.value();
			String tagName = findBy.tag();
			switch (tagName) {
			case "id":
				return new By.ById(value);

			case "xpath":
				return new By.ByXPath(value);

			case "css":
				return new By.ByCssSelector(value);

			case "className":
				return new By.ByClassName(value);

			case "linkText":
				return new By.ByLinkText(value);

			case "partialLinkText":
				return new By.ByPartialLinkText(value);

			case "name":
				return new By.ByName(value);

			case "tagName":
				return new By.ByTagName(value);
			}
		} catch (ElementNotVisibleException env) {
			// check if we have to throw exception from here to main test case
			env.toString();
		} catch (NoSuchElementException nse) {
		} catch (StaleElementReferenceException ser) {
		} catch (TimeoutException timeoutExc) {
		} catch (WebDriverException exc) {
		}
		return null;
	}

	@Override
	public boolean isLookupCached() {
		return (field.getAnnotation(CacheLookup.class) != null);
	}
}
