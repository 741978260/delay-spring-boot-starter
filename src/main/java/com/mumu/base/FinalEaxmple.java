package com.mumu.base;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/15
 */
public class FinalEaxmple {
    private final String name;

    public FinalEaxmple(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 会执行到初始化阶段
        Class<?> aClass = Class.forName("");
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass1 = systemClassLoader.loadClass("");
    }

}
