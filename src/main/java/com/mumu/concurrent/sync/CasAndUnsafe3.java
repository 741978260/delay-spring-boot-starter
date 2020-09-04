package com.mumu.concurrent.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/3
 */
public class CasAndUnsafe3 {
    //    public static /*volatile*/ int m = 0;
    private static AtomicInteger m = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    m.incrementAndGet(); // m++
                }
                latch.countDown();
            });
        }
        Arrays.stream(threads).forEach(t -> t.start());

        latch.await();

        System.out.println(m);

    }
}
