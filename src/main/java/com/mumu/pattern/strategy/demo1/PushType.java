package com.mumu.pattern.strategy.demo1;

import java.lang.annotation.*;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface PushType {
    /**
     * 推送类型枚举
     */
    PushTypeEnum value();
}
