package com.mumu.concurrent.chapter03;

/**
 * @Description 线程优先级 如果CPU比较忙，设置优先级可能会获得更多的时间片，但是闲时优先级的高低几乎不会有任何作用
 * @Author Created by Mumu
 * @Date on 2020/10/11
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("t1");
            }
        });
        t1.setPriority(3);

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("t1");
            }
        });
        t2.setPriority(10);

        t1.start();
        ;
        t2.start();
    }
}
