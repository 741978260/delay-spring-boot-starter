package com.mumu.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/13
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("oh，i am be interrupted");
            }

        });

        thread.start();

        // 短暂阻塞确保thread启动
        TimeUnit.MILLISECONDS.sleep(2);

        thread.interrupt();

    }
}
