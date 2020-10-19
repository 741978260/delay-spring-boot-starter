package com.mumu.concurrent.chapter08;

import java.util.LinkedList;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public class LinkedRunnableQueue implements RunnableQueue {

    // 任务队列的最大容量 在构造时传入
    private final int limit;

    // 若任务队列中的任务已经满了，则需要执行拒绝策略
    private final DenyPolicy denyPolicy;

    // 存放任务的队列
    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                //
                denyPolicy.reject(runnable, threadPool);
            } else {
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    // 如果任务队列中没有可执行任务，则当前线程将会挂起，进入runnableList关联的monitor waitset中等待唤醒（新的任务加入）
                    runnableList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 被中断时 需要将该任务抛出
                    throw e;
                }
            }
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        return runnableList.size();
    }
}
