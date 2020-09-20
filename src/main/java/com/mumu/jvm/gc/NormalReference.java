package com.mumu.jvm.gc;

import java.io.IOException;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc();

        System.in.read();//阻塞main线程，给垃圾回收线程时间执行
    }
}
