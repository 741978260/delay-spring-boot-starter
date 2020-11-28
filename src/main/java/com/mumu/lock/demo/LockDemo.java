package com.mumu.lock.demo;

import lombok.Data;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/25
 */
@Data
public class LockDemo {
    final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        final LockDemo lockDemo = new LockDemo();
        lockDemo.getLock().lock();
        final Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            lockDemo.getLock().lock();

            lockDemo.getLock().unlock();
        });
        thread.start();
        thread.join();

        lockDemo.getLock().unlock();
    }
}
