package com.mumu.common.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/4
 */
public class DelayConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.mumu.service.impl.TestServiceImpl"};
    }
}
