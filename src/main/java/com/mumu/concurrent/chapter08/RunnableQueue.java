package com.mumu.concurrent.chapter08;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public interface RunnableQueue {
    // 当有新的任务进来时首先会offer到队列中
    void offer(Runnable runnable);

    // 工作线程通过take方法获取Runnable
    Runnable take() throws InterruptedException;

    // 获取队列中任务的数量
    int size();
}
