package com.mumu.concurrent.examples;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description 利用队列的阻塞操作
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class BlockQueueExample1 {
    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {

        char[] c1 = "123456".toCharArray();
        char[] c2 = "ABCDEF".toCharArray();

        new Thread(() -> {
            for (char c : c1) {
                System.out.println(c);
                try {
                    q1.put("ok");
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : c2) {
                try {
                    q1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(c);
                try {
                    q2.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();


    }

}
