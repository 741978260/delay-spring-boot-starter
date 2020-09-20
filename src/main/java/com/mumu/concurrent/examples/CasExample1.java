package com.mumu.concurrent.examples;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class CasExample1 {
    enum ReadyToRun {T1, T2,T3}

    /**
     * 思考为什么必须volatile
     */
    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] c1 = "123456".toCharArray();
        char[] c2 = "ABCDEF".toCharArray();
        char[] c3 = "一二三四五六".toCharArray();

        new Thread(() -> {
            for (char c : c1) {
                // 不是T1 就空转 等着
                while (r != ReadyToRun.T1) {
                }
                System.out.println(c);
                r = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : c2) {
                while (r != ReadyToRun.T2) {
                }
                System.out.println(c);
                r = ReadyToRun.T3;
            }
        }, "t2").start();

        new Thread(() -> {
            for (char c : c3) {
                while (r != ReadyToRun.T3) {
                }
                System.out.println(c);
                r = ReadyToRun.T1;
            }
        }, "t3").start();

    }

}
