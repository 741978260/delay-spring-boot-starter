package com.mumu.cache.custom;

import lombok.Data;

import java.util.Date;

/**
 * @Description 缓存实体类
 * @Author Created by Mumu
 * @Date on 2020/6/27
 */
@Data
public class CacheValue {
    /**
     * 缓存的key
     */
    private Object key;
    /**
     * 缓存值
     */
    private Object value;
    /**
     * 过期时间，单位秒
     */
    private long expireTimes;
    /**
     * 缓存的存入时间
     */
    private Date cacheTime;
    /**
     * 最后使用时间
     */
    private Date lastUsedTime;
    /**
     * 命中次数 （预留字段，用于支持LFU缓存淘汰）
     */
    private int hits;
}
