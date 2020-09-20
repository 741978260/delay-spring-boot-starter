package com.mumu.jvm.gc;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
//        super.finalize();
        System.out.println("finalize");
    }
}
