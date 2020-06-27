package com.mumu.cache.custom;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description Cache 全局类
 * @Author Created by Mumu
 * @Date on 2020/6/27
 */
public class CacheGlobal {
    // 全局缓存对象
    public static ConcurrentHashMap<String, CacheValue> concurrentMap = new ConcurrentHashMap<>();
}
