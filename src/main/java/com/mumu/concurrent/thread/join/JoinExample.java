package com.mumu.concurrent.thread.join;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description join()：在一个线程中，调用other.join(),这时候当前线程会让出执行权给other线程，直到other线程执行完，或者过了超时时间之后，再继续执行当前线程，
 * 从源码可以看出，join底层还是通过wait()方法来实现
 * @Author Created by Mumu
 * @Date on 2020/8/1
 */
public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
//        join1();
        join2();
    }

    private static void join2() throws InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        final Random random = new Random();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
//                System.out.println("线程：" + Thread.currentThread().getName());
                int num = random.nextInt() * 10;
                list.add(num);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        System.out.println("size：" + list.size());
    }

    private static void join1() throws InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
//                System.out.println("线程：" + Thread.currentThread().getName());
                int num = random.nextInt() * 10;
                list.add(num);
            });
            // main线程执行
            thread.start();
            // main线程执行，让出cpu执行权，给thread线程执行，保证顺序
            thread.join();
        }

        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        System.out.println("size：" + list.size());
    }
}
