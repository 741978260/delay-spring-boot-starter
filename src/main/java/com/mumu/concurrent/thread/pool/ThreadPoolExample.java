package com.mumu.concurrent.thread.pool;

import java.util.concurrent.*;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/6/21
 */
public class ThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20));
        // execute使用
        executor.execute(() -> {
            System.out.println("hello,execute.");
        });

        // submit使用
        Future<String> future = executor.submit(() -> {
            Thread.sleep(5000L);
            System.out.println("hello,submit.");
            return "success";
        });
        System.out.println(future.get());

    }
}
