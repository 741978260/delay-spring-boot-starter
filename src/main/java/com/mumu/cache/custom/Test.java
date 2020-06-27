package com.mumu.cache.custom;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/6/27
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {


        System.out.println("当前时间：" + new Date());


        CacheUtil.add("key1", "hello,key1", 12);
        CacheUtil.add("key2", "hello,key2", 14);
        CacheUtil.add("key3", "hello,key3", 16);
        CacheUtil.add("key4", "hello,key4", 18);
        CacheUtil.add("key5", "hello,key5", 20);
        CacheUtil.add("key6", "hello,key6", 25);


        for (int j = 0; j < 20; j++) {
            Thread.sleep(1000);
            int i = (int) (Math.random() * 10);
            String key = "key" + i;
            Object result = CacheUtil.get(key);
            System.out.println("查询缓存" + key + ",值:" + result);
        }

        ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(1);
        ScheduledFuture<?> scheduledFuture = poolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("线程名称：" + Thread.currentThread().getName() + ",当前时间：" + new Date());
            //检测并删除过期的key
            ConcurrentHashMap<String, CacheValue> map = CacheUtil.getAll();
            for (CacheValue value : map.values()) {
                //到期
                if (System.currentTimeMillis() - (value.getCacheTime().getTime() + value.getExpireTimes() * 1000) >= 0) {
                    CacheUtil.delete((String) value.getKey());
                    System.out.println(value.getKey() + "删除缓存成功..." + new Date());
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
