package com.tpg.quality.web.pagefactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.tpg.quality.web.annotation.CustomElementLocator;
import com.tpg.quality.web.webelements.CustomElement;
import com.tpg.quality.web.webelements.ImplementedBy;

public class CustomLocatingElementHandler implements InvocationHandler {
	// Changed the locator type from ElementLocator to CustomElementLocator
	CustomElementLocator locator;
	Class<?> wrappingType;

	public <T> CustomLocatingElementHandler(Class<T> fieldType, CustomElementLocator locator) {
		this.locator = locator;
		if (!CustomElement.class.isAssignableFrom(fieldType)) {
			throw new RuntimeException("interface is not assignable to an Element");
		}
		this.wrappingType = getWrapperClass(fieldType);
	}

	/**
	 * Fetches the wrapper class from the annotation @ImplementedBy.
	 *
	 * @param innterface interface to process for annotations
	 * @param <T> type of the wrapped class.
	 * @return The custom WebElement implementation class
	 */
	public static <T> Class<?> getWrapperClass(Class<T> innterface) {
		if (innterface.isAnnotationPresent(ImplementedBy.class)) {
			ImplementedBy annotation = innterface.getAnnotation(ImplementedBy.class);
			Class<?> customElementImplClass = annotation.value();
			if (CustomElement.class.isAssignableFrom(customElementImplClass)) {
				return annotation.value();
			}
		}
		throw new UnsupportedOperationException("Apply @ImplementedBy annotation to your Interface "
				+ innterface.getCanonicalName() + " if you want to use it as a wrapper");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
		WebElement element;
		try {
			element = locator.findElement();
		} catch (NoSuchElementException e) {
			if ("toString".equals(method.getName())) {
				return "Proxy element for: " + locator.toString();
			}
			throw e;
		}
		if ("getWrappedElement".equals(method.getName())) {
			return element;
		}
		Constructor<?> cons = wrappingType.getConstructor(WebElement.class);
		Object obj = cons.newInstance(element);
		try {
			return method.invoke(wrappingType.cast(obj), objects);
		} catch (InvocationTargetException e) {
			// Unwrap the underlying exception
			throw e.getCause();
		}
	}
}
