package com.tpg.quality.web.webelements;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.tpg.quality.web.elementImpl.CustomElementImpl;

/**
 * Sets the default implementing class for the annotated interface.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementedBy {
	/**
	 * Passing class as default, that is implementing our custom element
	 * interface.
	 */
	Class<?> value() default CustomElementImpl.class;
}
