package com.mumu.common.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/10
 */
@Slf4j
public class AtomicCounterResolver {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private RedisScript<Long> counterRedisScript;

    /**
     * 功能描述： 计数操作，超时时间只在初始化时设置
     *
     * @param key         key
     * @param initCounter 初始化计数器
     * @param seconds     超时时间，初始化时配置，传0则意味着不过期
     *
     * @return 出参
     */
    public boolean increment(String key, int initCounter, int seconds) {
        if (initCounter <= 0) {
            return false;
        }
        try {
            Object result = redisTemplate.execute(counterRedisScript, Stream.of(key).collect(Collectors.toList()), String.valueOf(initCounter), String.valueOf(seconds));
            return Objects.equals(String.valueOf(result), "1");
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/redis_counter.lua")));
        defaultRedisScript.setResultType(Long.class);
        this.counterRedisScript = defaultRedisScript;
    }
}
