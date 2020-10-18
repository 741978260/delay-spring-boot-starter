package com.mumu.concurrent.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class ThreadGroupEnumerateThreads {
    public static void main(String[] args) throws InterruptedException {
        final ThreadGroup myGroup = new ThreadGroup("MyGroup");

        Thread thread = new Thread(myGroup, () -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "MyThread");
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        final ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        Thread[] list = new Thread[mainGroup.activeCount()];
        int recursSize = mainGroup.enumerate(list);
        System.out.println(recursSize);

        recursSize = mainGroup.enumerate(list, false);
        System.out.println(recursSize);
    }
}
