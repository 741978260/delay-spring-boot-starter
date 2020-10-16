package com.mumu.concurrent.chapter03;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/11
 */
public class CurrentThread {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() == this);
                System.out.println(Thread.currentThread().getContextClassLoader());
            }
        };
        thread.start();

        final String name = Thread.currentThread().getName();
        System.out.println("main".equals(name));

        System.out.println("main : " + Thread.currentThread().getContextClassLoader());
    }
}
