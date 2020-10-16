package com.mumu.concurrent.chapter03;

import java.util.stream.IntStream;

/**
 * @Description yield方法属于一种启发式的方法，其会提醒调度器我愿意放弃当前的CPU资源，如果CPU的资源不紧张，则会忽略这种提醒
 * 调用yield方法会使当前线程从Running状态切换到Runnable状态，一般这个方法不太常用
 * @Author Created by Mumu
 * @Date on 2020/10/11
 */
public class ThreadYield {
    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() -> {
            // 注释部分
            if(index == 0)
             Thread.yield();
            System.out.println(index);
        });
    }

//    private static <U> U create(int i) {
//        return null;
//    }
}
