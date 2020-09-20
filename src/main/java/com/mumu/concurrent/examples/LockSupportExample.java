package com.mumu.concurrent.examples;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class LockSupportExample {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        char[] c1 = "123456".toCharArray();
        char[] c2 = "ABCDEF".toCharArray();

        t1 = new Thread(() -> {
            for (char c : c1) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (char c : c2) {
                // t2上来先阻塞，保证t1先打印
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();

    }

}
