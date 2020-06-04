package com.mumu.common.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@Import(DelayConfigurationSelector.class)
public @interface EnableDelay {
}
