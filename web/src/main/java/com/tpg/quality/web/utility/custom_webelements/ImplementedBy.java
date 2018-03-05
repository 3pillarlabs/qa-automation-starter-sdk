package com.tpg.quality.web.utility.custom_webelements;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sets the default implementing class for the annotated interface.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementedBy {
    /**
     * Passing class as default, that is implementing our custom element interface.
     */
    Class<?> value() default CustomElementImpl.class;
}
