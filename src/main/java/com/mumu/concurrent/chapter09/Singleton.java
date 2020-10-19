package com.mumu.concurrent.chapter09;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public class Singleton {
    // 1
    private static int x = 0;
    private static int y;

    private static Singleton instance = new Singleton(); // 2

    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        // 1 和 2 的位置，调换顺序后，输出结果 不一样
        System.out.println(singleton.x);
        System.out.println(singleton.y);

    }
}
