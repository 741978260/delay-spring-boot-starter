package com.mumu.concurrent.sync;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 缓存行对齐  （intel cpu MESI 缓存一致性协议）
 * @Author Created by Mumu
 * @Date on 2020/9/5
 */
public class CacheLinePadding_Deprecated {


    public static long COUNT = 1_0000_0000L; // 占 8字节  ；缓存行 占64字节

    private static class T {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);


    }

}
