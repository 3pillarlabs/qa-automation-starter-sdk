package com.tpg.quality.web.pagefactory;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.tpg.quality.web.annotation.CustomElementLocator;
import com.tpg.quality.web.webelements.CustomElement;

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
		List allClasses = getAllClasses("com.tpg.quality.web.elementImpl");
		for(int i=0; i<allClasses.size() ; i++){
			String className = (String)allClasses.get(i).toString();
			if(className.contains("class")){
				if(innterface.isAssignableFrom((Class)allClasses.get(i))){
					return (Class)allClasses.get(i);
				}
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

	private static List getAllClasses(String pckgname) {
		try{
			ArrayList result=new ArrayList(); 
			// Get a File object for the package 
			File directory=null; 
			try { 
				directory=new File(Thread.currentThread().getContextClassLoader().getResource(pckgname.replace('.', '/')).getFile()); 
			} catch(NullPointerException x) { 
				throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
			} 
			if(directory.exists()) { 
				// Get the list of the files contained in the package 
				String[] files=directory.list(); 
				for(int i=0; i<files.length; i++) { 
					// we are only interested in .class files 
					if(files[i].endsWith(".class")) { 
						// removes the .class extension 
						result.add(Class.forName(pckgname+'.'+files[i].substring(0, files[i].length()-6))); 
					} 
				} 
			} else { 
				throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
			} 
			return result;		   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
