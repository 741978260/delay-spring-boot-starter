package com.mumu.jvm.gc;

import java.lang.ref.WeakReference;

/**
 * @Description 弱引用 示例（只要有垃圾回收，就被干掉，不管内存够不够）
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

    }
}
