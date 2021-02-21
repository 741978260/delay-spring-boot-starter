package com.mumu.highconcurrent.async.demo;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/2/3
 */
public interface RemoteLoader {
    String load();

    default void delay() {
        try {
            System.out.println("当前类：" + this.getClass().getSimpleName() + " 线程：" + Thread.currentThread().getName());
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
