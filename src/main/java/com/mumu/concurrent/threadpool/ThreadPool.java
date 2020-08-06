package com.mumu.concurrent.threadpool;

import java.util.List;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/8/3
 */
public interface ThreadPool {
    /**
     * 执行任务
     *
     * @param task
     */
    void execute(Runnable task);

    void execute(Runnable[] tasks);

    void execute(List<Runnable> tasks);

    /**
     * 返回执行任务的个数
     *
     * @return
     */
    int getExecuteTaskNumber();

    /**
     * 返回任务队列长度，即还没处理的任务个数
     *
     * @return
     */
    int getWaitTaskNumber();

    /**
     * 返回工作线程个数
     *
     * @return
     */
    int getWorkThreadNumber();

    /**
     * 关闭线程池
     */
    void destroy();
}
