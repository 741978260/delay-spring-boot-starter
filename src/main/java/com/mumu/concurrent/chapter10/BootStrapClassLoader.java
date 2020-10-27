package com.mumu.concurrent.chapter10;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/20
 */
public class BootStrapClassLoader {
    public static void main(String[] args) {
        System.out.println("Bootstrap:" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
