package com.mumu.concurrent.chapter03;

/**
 * @Description sleep 方法介绍，sleep 不会放弃monitor锁的所有权
 * @Author Created by Mumu
 * @Date on 2020/10/11
 */
public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            sleep(2000);
            long endTime = System.currentTimeMillis();
            System.out.println();
        }).start();


        long startTime = System.currentTimeMillis();
        sleep(2000);
        long endTime = System.currentTimeMillis();
        System.out.println();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
