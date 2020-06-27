package com.mumu.thread.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/6/26
 */
public class ThreadDemo {
    private static int initNum;

    private String name;

    public static synchronized int nextInitNum() {
        return initNum++;
    }

    public ThreadDemo() {
        init("ThreadDemo-" + nextInitNum());
    }

    public void init(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ThreadDemo threadDemo = new ThreadDemo();
                System.out.println(threadDemo.name);
            });
            thread.start();
            cdl.countDown();
        }
    }
}
