package com.mumu.concurrent.atomics;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/25
 */
public class AtomicIntegerExample {
    static AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) {
        a.getAndIncrement();
    }
}
