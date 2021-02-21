package com.mumu.highconcurrent.async.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/2/3
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        testSync();
//        testFuture();
//        testParallelStream();
//        testCompletableFuture();
//        testCompletableFuture2();
        testCompletableFuture3();
    }

    private static void testCompletableFuture3() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            doSomething();
            return "Finish";
        });
        System.out.println(future.get());
    }

    private static void testCompletableFuture2() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                doSomething2();
                future.complete("Finish");//任务执行完成后 设置返回的结果
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }).start();
        System.out.println(future.get()); //获取任务线程返回的结果
    }

    private static void doSomething2() {
        System.out.println("doSomething...");
        throw new RuntimeException("Test Exception");
    }

    private static void testCompletableFuture() {
        final CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            doSomething();
            future.complete("Finish");//任务执行完成后 设置返回的结果
        }).start();
        System.out.println(future.join()); //获取任务线程返回的结果
    }

    private static void doSomething() {
        System.out.println("doSomething...");
    }

    private static void testParallelStream() {
        long start = System.currentTimeMillis();
        final List<RemoteLoader> remoteLoaders = Arrays.asList(
                new CustomerInfoService(),
                new LearnRecordService(),
                new WatchRecordService(),
                new OrderService(),
                new LabelService());
        final List<String> customerDetail = remoteLoaders.parallelStream().map(RemoteLoader::load).collect(Collectors.toList());
        System.out.println(customerDetail);
        System.out.println("总共花费：" + (System.currentTimeMillis() - start));
    }


    private static void testFuture() {
        long start = System.currentTimeMillis();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final List<RemoteLoader> remoteLoaders = Arrays.asList(new CustomerInfoService(), new LearnRecordService());
        final List<Future<String>> futures = remoteLoaders.stream().map(remoteLoader -> executorService.submit(remoteLoader::load)).collect(Collectors.toList());
        final List<String> customerDetail = futures.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        executorService.shutdown();
        System.out.println(customerDetail);
        System.out.println("总共花费：" + (System.currentTimeMillis() - start));
    }

    private static void testSync() {
        long start = System.currentTimeMillis();
        final List<RemoteLoader> remoteLoaders = Arrays.asList(new CustomerInfoService(), new LearnRecordService());
        final List<String> customerDetail = remoteLoaders.stream().map(RemoteLoader::load).collect(Collectors.toList());
        System.out.println(customerDetail);
        System.out.println("总共花费：" + (System.currentTimeMillis() - start));
    }
}
