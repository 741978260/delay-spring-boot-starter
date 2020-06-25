package com.mumu.thread.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description ThreadPoolExecutor扩展
 * @Author Created by Mumu
 * @Date on 2020/6/21
 */
public class ThreadPoolExtend {
    public static void main(String[] args) {
        //线程池扩展调用
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(2, 4, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                Thread.currentThread().getName();
            });
        }

    }

    static class MyThreadPoolExecutor extends ThreadPoolExecutor {
        //保存线程执行开始时间
        private final ThreadLocal<Long> localTime = new ThreadLocal<>();

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        /**
         * 开始执行之前
         *
         * @param t 线程
         * @param r 任务
         */
        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            Long l = System.nanoTime();//开始时间，单位纳秒
            localTime.set(l);
            System.out.println(String.format("%s|before|time=%s", t.getName(), l));
            super.beforeExecute(t, r);
        }

        /**
         * 执行完成之后
         *
         * @param r 任务
         * @param t 抛出的异常
         */
        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            Long eTime = System.nanoTime();//结束时间，单位纳秒
            Long totalTime = eTime - localTime.get();// 执行总时间
            System.out.println(String.format("%s|after|time=%s|耗时：%s毫秒", Thread.currentThread().getName(),
                    eTime, (totalTime / 1000000.0)));
            super.afterExecute(r, t);
        }
    }
}
