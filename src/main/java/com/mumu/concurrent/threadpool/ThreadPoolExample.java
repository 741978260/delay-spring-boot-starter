package com.mumu.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/29
 */
public class ThreadPoolExample {
    public static void main(String[] args) {

        //ExecutorService executorService = Executors.newCachedThreadPool();//一池n个线程
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);//一池5个线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();//一池1个线程

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        executorService.shutdown();

        for (int i = 0; i < 10; i++) {
            executorService2.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        executorService2.shutdown();

        Thread thread = new Thread(new Task());
        thread.start();

    }

    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("task...");
        }
    }
}
