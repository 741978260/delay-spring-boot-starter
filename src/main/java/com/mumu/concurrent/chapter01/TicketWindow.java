package com.mumu.concurrent.chapter01;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/26
 */
public class TicketWindow extends Thread {
    /**
     * 柜台名称
     */
    private final String name;
    /**
     * 最多受理50笔业务
     */
    private static final int MAX = 100000;

    private static int index = 1; // static 修饰

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + "当前的号码是：" + (index++));
        }
    }

    public static void main(String[] args) {
        new TicketWindow("一号出号机").start();
        new TicketWindow("二号出号机").start();
        new TicketWindow("三号出号机").start();
        new TicketWindow("四号出号机").start();
    }
}
