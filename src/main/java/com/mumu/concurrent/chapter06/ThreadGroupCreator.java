package com.mumu.concurrent.chapter06;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class ThreadGroupCreator {
    public static void main(String[] args) {
        // 获取当前线程的group
        final ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        final ThreadGroup group1 = new ThreadGroup("Group1");

        // 程序输出true
        System.out.println(group1.getParent() == currentGroup);

        final ThreadGroup group2 = new ThreadGroup(group1, "Group2");

        // 程序输出true
        System.out.println(group2.getParent() == group1);

    }
}
