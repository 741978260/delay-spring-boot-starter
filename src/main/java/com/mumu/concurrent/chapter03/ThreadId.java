package com.mumu.concurrent.chapter03;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/11
 */
public class ThreadId {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getId());
        }).start();
    }
}
