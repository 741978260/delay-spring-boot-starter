package com.mumu.concurrent.chapter09;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public class ClassInit2 {
    static {
        System.out.println("The ClassInit2 static code block will be invoke.");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> new Thread(ClassInit2::new));
    }
}
