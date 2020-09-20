package com.mumu.concurrent.examples;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class WaitNotifyExample {

    public static void main(String[] args) {
        char[] c1 = "123456".toCharArray();
        char[] c2 = "ABCDEF".toCharArray();

        Object o = new Object();

        CountDownLatch cdl = new CountDownLatch(1);

        new Thread(() -> {
            synchronized (o) {
                for (char c : c1) {
                    System.out.print(c);
                    cdl.countDown();
                    try {
                        o.notify();// 唤醒 等待队列中的某一个线程（等待队列中的线程必须被叫醒，才能往后执行，去获取锁）
                        o.wait();// 当前线程让出锁，进入等待队列
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();// 必须，否则无法停止程序。
            }
        }).start();

        new Thread(() -> {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                for (char c : c2) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();// 必须，否则无法停止程序。
            }
        }).start();

    }
}
