package com.mumu.concurrent.chapter05;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public interface Lock {
    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();


}
