package com.mumu.concurrent.chapter01;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/26
 */
public class TicketWindowRunnable implements Runnable {
    /**
     * 最多受理50笔业务
     */
    private static final int MAX = 100000;

    private int index = 1; //不做 static 修饰

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + Thread.currentThread().getName() + "当前的号码是：" + (index++));
        }
    }


    public static void main(String[] args) {
        TicketWindowRunnable task = new TicketWindowRunnable();
        new Thread(task, "一号窗口 ").start();
        new Thread(task, "二号窗口 ").start();
        new Thread(task, "三号窗口 ").start();
        new Thread(task, "四号窗口 ").start();
    }
}
