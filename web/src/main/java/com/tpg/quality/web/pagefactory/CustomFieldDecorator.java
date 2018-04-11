package com.tpg.quality.web.pagefactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import com.tpg.quality.web.annotation.CustomElementLocator;
import com.tpg.quality.web.annotation.CustomElementLocatorFactory;
import com.tpg.quality.web.annotation.FindBy;
import com.tpg.quality.web.webelements.CustomElement;

/**
 * CustomFieldDecorator implements the default FieldDecorator and overrides the
 * decorate() method.
 * 
 * @author satnam.malhotra
 *
 */
public class CustomFieldDecorator implements FieldDecorator {

	protected CustomElementLocatorFactory factory;

	public CustomFieldDecorator(CustomElementLocatorFactory factory) {
		this.factory = factory;
	}

	/**
	 * Changed the locator type from ElementLocator to CustomElementLocator so
	 * that it could decorate our custom elements.
	 */
	@Override
	public Object decorate(ClassLoader loader, Field field) {
		if (!(WebElement.class.isAssignableFrom(field.getType()) || isDecoratableList(field))) {
			return null;
		}
		CustomElementLocator locator = factory.createLocator(field);
		if (locator == null) {
			return null;
		}

		// Here calling CustomElement class and sending it for fieldType
		Class<?> fieldType = field.getType();
		if (WebElement.class.equals(fieldType)) {
			fieldType = CustomElement.class;
		}

		if (List.class.isAssignableFrom(fieldType)) {
			Class<?> erasureClass = getErasureClass(field);
			return proxyForListLocator(loader, erasureClass, locator);
		}
		else if (WebElement.class.isAssignableFrom(fieldType)) {
			return proxyForLocator(loader, fieldType, locator);
		} 
		else {
			return null;
		}
	}

	protected boolean isDecoratableList(Field field) {
		if (!List.class.isAssignableFrom(field.getType())) {
			return false;
		}

		// Type erasure in Java isn't complete. Attempt to discover the generic
		// type of the list.
		Type genericType = field.getGenericType();
		if (!(genericType instanceof ParameterizedType)) {
			return false;
		}

		Class<?> erasureClass = getErasureClass(field);
		if (erasureClass == null) {
			return false;
		}

		//Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];

		/*if (!WebElement.class.equals(listType)) {
			return false;
		}*/

		if (field.getAnnotation(FindBy.class) == null && field.getAnnotation(FindBys.class) == null
				&& field.getAnnotation(FindAll.class) == null) {
			return false;
		}

		return true;
	}

	/**
	 * Changed elementLocator to customElementLocator type in the parameters
	 * because we have to use our locator mechanism. This method will create a
	 * proxy to locate an element.
	 * 
	 * @param loader
	 * @param fieldType
	 * @param locator
	 * @return proxy
	 */
	protected <T> T proxyForLocator(ClassLoader loader, Class<T> fieldType, CustomElementLocator locator) {
		InvocationHandler handler = new CustomLocatingElementHandler(fieldType, locator);

		T proxy;
		proxy = fieldType.cast(Proxy.newProxyInstance(loader,
				new Class[] { fieldType, WebElement.class, WrapsElement.class, Locatable.class }, handler));
		return proxy;
	}

	/**
	 * Changed elementLocator to customElementLocator type in the parameters
	 * because we have to use our locator mechanism. This method will create a
	 * proxy to locate an element.
	 * 
	 * @param loader
	 * @param fieldType
	 * @param locator
	 * @return proxy
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> proxyForListLocator(ClassLoader loader, Class<T> fieldType, CustomElementLocator locator) {
		InvocationHandler handler = new CustomLocatingElementListHandler(fieldType, locator);
		List<T> proxy;
		proxy = (List<T>) Proxy.newProxyInstance(loader, new Class[] { List.class }, handler);
		return proxy;



	}

	private Class<?> getErasureClass(Field field) {
		// Type erasure in Java isn't complete. Attempt to discover the generic
		// interfaceType of the list.
		Type genericType = field.getGenericType();
		if (!(genericType instanceof ParameterizedType)) {
			return null;
		}
		return (Class<?>) ((ParameterizedType) genericType).getActualTypeArguments()[0];
	}
}
