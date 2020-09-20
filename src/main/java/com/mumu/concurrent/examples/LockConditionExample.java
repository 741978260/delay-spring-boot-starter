package com.mumu.concurrent.examples;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class LockConditionExample {
    public static void main(String[] args) {
        char[] c1 = "123456".toCharArray();
        char[] c2 = "ABCDEF".toCharArray();

        Lock lock = new ReentrantLock();
        Condition conditionT1 = lock.newCondition();
        Condition conditionT2 = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();

                for (char c : c1) {
                    System.out.print(c);
                    conditionT2.signal();
                    conditionT1.await();
                }

                conditionT2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();

                for (char c : c2) {
                    System.out.print(c);
                    conditionT1.signal();
                    conditionT2.await();
                }

                conditionT1.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
