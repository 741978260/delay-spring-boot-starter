package com.mumu.concurrent.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/3
 */
public class CasAndUnsafe2 {
    public static /*volatile*/ int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        Object o = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (o) {
                    for (int j = 0; j < 10000; j++) {
                        m++;
                    }
                }
                latch.countDown();
            });
        }
        Arrays.stream(threads).forEach(t -> t.start());

        latch.await();

        System.out.println(m);

    }
}
