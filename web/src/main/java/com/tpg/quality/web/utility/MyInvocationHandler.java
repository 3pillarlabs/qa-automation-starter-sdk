package com.tpg.quality.web.utility;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @author payal.gogia, satnam.malhotra
 *
 */
public class MyInvocationHandler implements InvocationHandler {

	Object obj;
	public MyInvocationHandler(Object o) {
		obj = o;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			return method.invoke(obj, args);
		} 
		catch (Exception e) 
		{
			throw e.getCause();
		}
	}

}
