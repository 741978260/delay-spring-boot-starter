package com.mumu.concurrent.chapter02;

/**
 * @Description 线程组概念
 * @Author Created by Mumu
 * @Date on 2020/10/11
 */
public class ThreadConstruction {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("TestGroup");

        Thread t2 = new Thread(group, "t2");
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("Main Thread belong group : " + (mainThreadGroup.getName()));
        System.out.println("t1 and main belong same group :" + (mainThreadGroup == t1.getThreadGroup()));


    }
}
