package com.mumu.jvm.gc;

import java.lang.ref.SoftReference;

/**
 * @Description 软引用 示例 （内存不够时回收，适合用做缓存）
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class T02_SoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());

        // 跑起来main方法时 指定jvm -Xmx = 20M .
        // 再分配一个数组，heap将装不下，这时系统会垃圾回收，先回收一次，如果不够，会被软引用回收掉
        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(m.get());
    }
}
