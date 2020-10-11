package com.mumu.concurrent.chapter02;

import java.util.Random;

/**
 * @Description 守护线程 什么是守护线程？为什么要有守护线程，以及何时需要守护线程？
 * JVM程序在上面情况下会退出 ？ 答案：在正常情况下，若JVM中没有一个非守护线程，则JVM的进程会退出。正常情况，而不是调用System.exit();
 * @Author Created by Mumu
 * @Date on 2020/10/11
 */
public class DemonThread {
    public static void main(String[] args) throws InterruptedException {
//        while (true) {
//            Random random = new Random();
//            int i = random.nextInt(10) + 1;
//            System.out.println(i);
//            if (i % 2 == 0) {
//                System.exit(1);
//            }
//        }
        // main线程开始
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true); // 将thread线程设置为非守护线程

        thread.start();// 启动thread线程
        Thread.sleep(2000);
        // main线程结束
    }
}
