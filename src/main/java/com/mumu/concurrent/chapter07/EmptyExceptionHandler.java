package com.mumu.concurrent.chapter07;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class EmptyExceptionHandler {
    public static void main(String[] args) {
        final ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup.getName());
        System.out.println(mainGroup.getParent());
        System.out.println(mainGroup.getParent().getParent());

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1 / 0);
        }, "Test-Thread").start();
    }
}
