package com.mumu.concurrent.chapter09;

import java.util.Random;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public class GlobalConstants {
    static {
        System.out.println("The GlobalConstants will be initialized");
    }

    // 在其他类使用MAX不会导致GlobalConstants的初始化，静态代码块不会输出
    public final static int MAX = 100;

    // 虽然RANDOM是静态常量，但是由于计算复杂，只有初始化之后才能得到结构，因此在其他类中使用RANDOM会导致GlobalConstants的初始化
    public final static int RANDOM = new Random().nextInt();
}
