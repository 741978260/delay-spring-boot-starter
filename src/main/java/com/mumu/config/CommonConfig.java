package com.mumu.config;

import com.mumu.common.annotation.EnableDelay;
import com.mumu.common.component.AtomicCounterResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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

    @Lazy
    @Bean
    public User getAAAAUser() {
        return new User("张三",18);
    }

    public static class User {
        private String name;
        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
