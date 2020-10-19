package com.mumu.concurrent.chapter08;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public class BasicThreadPool extends Thread implements ThreadPool {

    private final int initSize;

    private final int maxSize;

    private final int coreSize;

    private int activeCount;

    private final ThreadFactory threadFactory;

    private final RunnableQueue runnableQueue;

    private volatile boolean isShutdown = false;

    // 工作线程队列
//    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();

    private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();

    private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();

    private final long keepAliveTime;

    private final TimeUnit timeUnit;

    public BasicThreadPool(int initSize, int maxSize, int coreSize, ThreadFactory threadFactory, RunnableQueue runnableQueue, long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = runnableQueue;
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
    }

    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public int getInitSize() {
        return 0;
    }

    @Override
    public int getMaxSize() {
        return 0;
    }

    @Override
    public int getCoreSize() {
        return 0;
    }

    @Override
    public int getQueueSize() {
        return 0;
    }

    @Override
    public int getActiveCount() {
        return 0;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }
}
