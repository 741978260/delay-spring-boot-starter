package com.mumu.highconcurrent.chapter05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/11/22
 */
public class JavaFutureDemo {
    public static final int SLEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

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

    public static void drinkTea(boolean waterOk, boolean cupOk) {
        if (waterOk && cupOk) {
            System.out.println("泡茶喝");
        } else if (!waterOk) {
            System.out.println("烧水失败，没有茶喝了");
        } else if (!cupOk) {
            System.out.println("杯子洗不了，没有茶喝了");
        }
    }

    public static void main(String[] args) {
        final HotWaterJob hotWaterJob = new HotWaterJob();
        final FutureTask<Boolean> hTask = new FutureTask<>(hotWaterJob);
        final Thread hThread = new Thread(hTask, "**烧水-Thread");

        final WashJob washJob = new WashJob();
        final FutureTask<Boolean> wTask = new FutureTask<>(washJob);
        final Thread wThread = new Thread(wTask, "$$清洗-Thread");
        hThread.start();
        wThread.start();

        Thread.currentThread().setName("主线程");
        try {
            // 阻塞方法
            final Boolean waterOk = hTask.get();
            final Boolean cupOk = wTask.get();
            drinkTea(waterOk, cupOk);
        } catch (InterruptedException e) {
            System.out.println("发生异常中断.");
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("运行结束");
    }

}
