package com.mumu.highconcurrent.chapter05;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/12/26
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        demo1();
//        demo2();
//        demo3();
        asyncCallback();
    }

    private static void asyncCallback() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + " supplyAsync");
            return "123";
        });
        final CompletableFuture<Integer> result1 = completableFuture.thenApply((number) -> {
            System.out.println("线程" + Thread.currentThread().getName() + " thenApply1 ");
            return Integer.parseInt(number);
        });
        final CompletableFuture<Integer> result2 = result1.thenApply(number -> {
            System.out.println("线程" + Thread.currentThread().getName() + " thenApply2 ");
            return number * 2;
        });
        System.out.println("线程" + Thread.currentThread().getName() + " => " + result2.get());
    }

    private static void demo3() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行一个有返回值的异步任务。");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "OK";
        });
        String result = completableFuture.get();
        System.out.println(Thread.currentThread().getName() + "  结果：" + result);
    }

    private static void demo2() throws ExecutionException, InterruptedException {
        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行一个没有返回值的异步任务。");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        voidCompletableFuture.get();
        System.out.println(Thread.currentThread().getName() + " 结束。");
    }

    private static void demo1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行.....");
            completableFuture.complete("success");
        }).start();
        //主线程阻塞，等待完成
        String result = completableFuture.get();
        System.out.println(Thread.currentThread().getName() + " 1x:  " + result);
    }
}
