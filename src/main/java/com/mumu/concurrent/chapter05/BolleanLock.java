package com.mumu.concurrent.chapter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class BolleanLock implements Lock {

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                final Thread tempThread = currentThread();
                try {
                    // 该线程加入阻塞队列，并且使当前线程 wait 释放对 this monitor的所有权
                    if (!blockedList.contains(currentThread()))
                        blockedList.add(currentThread());
                    this.wait();
                } catch (InterruptedException e) {
                    // 如果当前线程在wait时被中断，则从blockList中将其删除，避免内存泄漏
                    blockedList.remove(tempThread);
                    // 继续抛出中断异常
                    throw e;
                }
            }
            // 当前锁没有被其他线程获得，则将该线程尝试从阻塞队列中删除自己（如果当前线程从未进入过阻塞队列，删除方法不会有任何影响；
            // 如果当前线程是从 wait set中被唤醒的，则需要从阻塞队列中将自己删除）
            blockedList.remove(currentThread());
            // locked开关设置为true
            this.locked = true;
            // 记录获取锁的线程
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = currentTimeMillis() + remainingMills;
                while (locked) {
                    if (remainingMills <= 0) {
                        throw new TimeoutException("can not get the lock during " + mills);
                    }
                    if (!blockedList.contains(currentThread())) {
                        blockedList.add(currentThread());
                    }
                    // 在等待remainingMills之前没有其他线程notify或者notifyAll，等待remainingMills之后自动唤醒
                    this.wait(remainingMills);
                    remainingMills = endMills - currentTimeMillis();
                }
                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (currentThread == currentThread()) {
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock.").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
