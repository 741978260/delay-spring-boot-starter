package com.mumu.concurrent.threadpool;

import java.util.List;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/8/3
 */
public class ThreadPoolManager implements ThreadPool {
    private static int workerNum = 5;
    @Override
    public void execute(Runnable task) {

    }

    @Override
    public void execute(Runnable[] tasks) {

    }

    @Override
    public void execute(List<Runnable> tasks) {

    }

    @Override
    public int getExecuteTaskNumber() {
        return 0;
    }

    @Override
    public int getWaitTaskNumber() {
        return 0;
    }

    @Override
    public int getWorkThreadNumber() {
        return 0;
    }

    @Override
    public void destroy() {

    }
}
