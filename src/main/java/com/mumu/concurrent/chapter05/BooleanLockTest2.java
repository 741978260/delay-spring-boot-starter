package com.mumu.concurrent.chapter05;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class BooleanLockTest2 {
    private final Lock lock = new BolleanLock();

    public void syncMethod() {
        //
        try {
            // 加锁
            lock.lock();

            int randomInt = ThreadLocalRandom.current().nextInt(10);
            System.out.println(currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public void syncMethodTimeoutable() {
        try {
            lock.lock(1000);
            System.out.println(currentThread() + " get the lock.");
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


//    public static void main(String[] args) throws InterruptedException {
//        BooleanLockTest2 blt = new BooleanLockTest2();
//        new Thread(blt::syncMethod, "T1").start();
//        TimeUnit.MILLISECONDS.sleep(2);
//        Thread t2 = new Thread(blt::syncMethod, "T2");
//        t2.start();
//        TimeUnit.MILLISECONDS.sleep(10);
//        t2.interrupt();
//    }

    public static void main(String[] args) throws InterruptedException {
        BooleanLockTest2 blt = new BooleanLockTest2();
        new Thread(blt::syncMethodTimeoutable, "T1").start();
        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2 = new Thread(blt::syncMethodTimeoutable, "T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
    }
}
