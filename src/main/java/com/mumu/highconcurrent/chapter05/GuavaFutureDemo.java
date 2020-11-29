package com.mumu.highconcurrent.chapter05;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/11/29
 */
public class GuavaFutureDemo {

    public static final int SLEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    // 业务逻辑：烧水
    static class HotWaterJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                System.out.println("洗好水壶");
                System.out.println("灌上凉水");
                System.out.println("放在火上");
                // 线程休眠一段时间，代表烧水中
                Thread.sleep(SLEEP_GAP);
                System.out.println("水开了");
            } catch (InterruptedException e) {
                System.out.println("发生异常被中断.");
                return false;
            }
            System.out.println("运行结束");
            return true;
        }
    }

    // 业务逻辑：清洗
    static class WashJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                System.out.println("洗茶壶");
                System.out.println("洗茶叶");
                System.out.println("拿茶叶");
                // 线程睡眠一段时间，代表清洗中
                Thread.sleep(SLEEP_GAP);
                System.out.println("洗好了");
            } catch (InterruptedException e) {
                System.out.println("清洗工作发生异常被中断");
                return false;
            }
            System.out.println("清洗工作运行结束");
            return true;
        }
    }

    // 新创建一个异步业务类型，作为泡茶喝主线程类
    static class MainJob implements Runnable {
        boolean waterOk = false;
        boolean cupOk = false;
        int gap = SLEEP_GAP;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(gap);
                    System.out.println("读书中....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (waterOk && cupOk) {
                    drinkTea(waterOk, cupOk);
                }
            }

        }

        public static void drinkTea(boolean waterOk, boolean cupOk) {
            if (waterOk && cupOk) {
                System.out.println("泡茶喝");
            } else if (!waterOk) {
                System.out.println("烧水失败，没有茶喝了");
            } else if (!cupOk) {
                System.out.println("杯子洗不了，没有茶喝了");
            }
        }
    }


    public static void main(String[] args) {
        // 创建一个新的线程实例，作为泡茶主线程
        MainJob mainJob = new MainJob();
        final Thread mainThread = new Thread(mainJob);
        mainThread.setName("主线程");

        // 烧水的业务逻辑
        Callable<Boolean> hotWaterJob = new HotWaterJob();
        // 清洗的业务逻辑实例
        Callable<Boolean> washJob = new WashJob();

        // 创建java线程池
        final ExecutorService jPool = Executors.newFixedThreadPool(10);
        // 包装Java线程池，构建Guava线程池
        final ListeningExecutorService gPool = MoreExecutors.listeningDecorator(jPool);

        // 提交烧水的业务逻辑实例，到Guava线程池获取异步任务
        final ListenableFuture<Boolean> hotFuture = gPool.submit(hotWaterJob);
        // 绑定异步回调，烧水完成后，把喝水任务的waterOk设置为true
        Futures.addCallback(hotFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                if (result) {
                    mainJob.waterOk = true;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("烧水失败，没有茶喝了");
            }
        });

        // 提交清洗的业务逻辑实例，到Guava线程池获取异步任务
        final ListenableFuture<Boolean> washFuture = gPool.submit(washJob);
        Futures.addCallback(washFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                if (result) {
                    mainJob.cupOk = true;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("杯子洗不了，没有茶喝了");
            }
        });
    }

}
