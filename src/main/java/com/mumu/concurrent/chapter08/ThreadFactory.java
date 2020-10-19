package com.mumu.concurrent.chapter08;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
@FunctionalInterface
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
