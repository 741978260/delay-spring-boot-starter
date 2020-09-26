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

    public static void main(String[] args) {
        LockDemo lockDemo1 = new LockDemo();
        LockDemo lockDemo2 = new LockDemo();
        System.out.println(lockDemo1.getLock());
        lockDemo1.getLock().lock();
        System.out.println(lockDemo1.getLock());
        lockDemo1.getLock().unlock();
        System.out.println(lockDemo1.getLock());
        System.out.println("------------------------");
        System.out.println(lockDemo2.getLock());
        System.out.println(lockDemo1.getLock() == lockDemo2.getLock());
        System.out.println(Objects.equals(lockDemo1.lock,lockDemo2.getLock()));
    }
}
