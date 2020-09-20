package com.mumu.jvm.gc;

/**
 * @Description threadlocal 示例 ---->  参考spring @Transactional 获取connection
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class ThreadLocal2 {

    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {


        new Thread(()->{

        }).start();


    }

    static class Person {
        String name = "张三";
    }
}
