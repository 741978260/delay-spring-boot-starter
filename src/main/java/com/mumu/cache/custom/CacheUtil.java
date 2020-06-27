package com.mumu.cache.custom;

import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/6/27
 */
public class CacheUtil {
    private static ConcurrentHashMap<String, CacheValue> map = new ConcurrentHashMap<>(16);

    public static void delete(String key) {
        map.remove(key);
    }

    /**
     * 添加缓存
     *
     * @param key     键
     * @param value   值
     * @param seconds 过期时间
     */
    public static void add(String key, Object value, long seconds) {
        if (StringUtils.isEmpty(key)) {
            return;
        }
        //缓存存在时，更新缓存
        if (map.containsKey(key)) {
            CacheValue cache = map.get(key);
            cache.setHits(cache.getHits() + 1);
            cache.setCacheTime(new Date());
            cache.setLastUsedTime(new Date());
            cache.setExpireTimes(seconds);
            cache.setValue(value);
            return;
        }
        //创建缓存
        CacheValue cacheValue = new CacheValue();
        cacheValue.setCacheTime(new Date());
        cacheValue.setKey(key);
        cacheValue.setValue(value);
        cacheValue.setLastUsedTime(new Date());
        cacheValue.setHits(1);
        cacheValue.setExpireTimes(seconds);
        map.put(key, cacheValue);
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Object get(String key) {
        //非空判断
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        // 字典中不存在
        if (map.isEmpty()) {
            return null;
        }
        if (!map.containsKey(key)) {
            return null;
        }
        CacheValue cacheValue = map.get(key);
        if (cacheValue != null) {
            // 惰性删除，判断缓存是否过期
            if (System.currentTimeMillis() - (cacheValue.getCacheTime().getTime() + cacheValue.getExpireTimes() * 1000) >= 0) {
                // 清除过期缓存
                delete(key);
                return null;
            }
            cacheValue.setLastUsedTime(new Date());
            cacheValue.setHits(cacheValue.getHits() + 1);
            return cacheValue.getValue();
        }
        return null;
    }

    public static ConcurrentHashMap<String, CacheValue> getAll() {
        return map;
    }
}
