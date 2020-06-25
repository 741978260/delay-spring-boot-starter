package com.mumu.lock.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/6/21
 */
public class LockExample {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        try {
            // 加锁
            lock.lock();
            // 业务处理

        } finally {
            // 释放锁
            lock.unlock();
        }

    }
}
