package com.mumu.concurrent.chapter09;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public class Simple {
    static {
        System.out.println("I will be initialized");
    }

    // 其他类即使不对Simple进行new的创建，直接访问变量x也会导致类的初始化
    public static int x = 10;

    public static void test() {
    }
}
