package com.mumu.config;

import com.mumu.common.annotation.EnableDelay;
import com.mumu.common.component.AtomicCounterResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/4
 */
@Configuration
@EnableDelay
public class CommonConfig {
    /**
     * 分布式原子计数器
     *
     * @return 出参
     */
    @Bean
    public AtomicCounterResolver atomicCounterResolver() {
        return new AtomicCounterResolver();
    }
}
