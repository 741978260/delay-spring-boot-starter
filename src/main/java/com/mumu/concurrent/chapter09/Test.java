package com.mumu.concurrent.chapter09;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public class Test {

    static {
        System.out.println("Test will be initialized");
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(Simple.x);
//        Simple.test();
        Class.forName("com.mumu.concurrent.chapter09.Simple");
    }
}
