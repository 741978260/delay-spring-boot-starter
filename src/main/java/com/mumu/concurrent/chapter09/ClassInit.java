package com.mumu.concurrent.chapter09;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public class ClassInit {
    static {
        // 静态语句块只能对后面的静态变量进行赋值，但是不能对其进行访问。
//        System.out.println(x); // 无法通过编译
        x = 100;
    }

    private static int x = 10;

    static class Parent {
        static int value = 10;

        static {
            value = 20;
        }
    }

    // 子类使用父类的静态变量为自己的静态变量赋值
    static class Child extends Parent {
        static int i = value;
    }

    public static void main(String[] args) {
        System.out.println(Child.i);
    }
}
