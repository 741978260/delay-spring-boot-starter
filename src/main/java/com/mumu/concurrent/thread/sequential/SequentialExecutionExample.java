package com.mumu.concurrent.thread.sequential;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 线程顺序执行
 * @Author Created by Mumu
 * @Date on 2020/7/25
 */
public class SequentialExecutionExample {

    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task(count, 0);
        Task task2 = new Task(count, 1);
        Task task3 = new Task(count, 2);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);
    }

    static class Task implements Runnable {
        private AtomicInteger count;
        private int order;

        public Task(AtomicInteger count, int order) {
            this.count = count;
            this.order = order;
        }

        @Override
        public void run() {
            while (true) {
                if (count.get() % 3 == order) {
                    System.out.println(Thread.currentThread().getName() + "=======" + order);
                    count.incrementAndGet();
                }
            }
        }
    }


}
