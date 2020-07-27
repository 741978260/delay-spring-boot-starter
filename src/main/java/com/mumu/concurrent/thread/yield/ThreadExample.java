package com.mumu.concurrent.thread.yield;

/**
 * @Description yield(): yield()方法为本地方法，也就是说yield()是由C或者C++实现的
 * yield()方法表示 给线程调度器一个当前线程愿意出让CPU使用权的暗示，但线程调度器可能会忽略这个暗示
 * @Author Created by Mumu
 * @Date on 2020/6/20
 */
public class ThreadExample {

    /**
     * 执行多次之后发现，每次执行的结果都不相同，这是因为yield方法执行非常不稳定，线程调度器不一定会采纳yield的出让
     * CPU使用权的建议，从而导致了这样的结果。
     *
     * @param args
     */
    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程" +
                        Thread.currentThread().getName() + "|:" + i);
                if (i == 5) {
                    Thread.yield();
                }
            }
        };

        Thread t1 = new Thread(runnable, "T1");
        Thread t2 = new Thread(runnable, "T2");

        t1.start();
        t2.start();


    }
}
