package com.mumu.concurrent.chapter02;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Description 线程名称的概念
 * @Author Created by Mumu
 * @Date on 2020/10/11
 */
public class ThreadNameExample {
    public static void main(String[] args) {
        IntStream.range(0, 5).boxed().map(i -> new Thread(
                () -> System.out.println(Thread.currentThread().getName()))
        ).forEach(Thread::start);
    }
}
