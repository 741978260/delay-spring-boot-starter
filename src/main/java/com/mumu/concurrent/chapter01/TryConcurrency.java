package com.mumu.concurrent.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/26
 */
public class TryConcurrency {

    public static void main(String[] args) {
//        browseNews();
//        enjoyMusic();
        new Thread(TryConcurrency::browseNews).start();
        enjoyMusic();
    }

    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("hah,the good news.");
            sleep(1);
        }
    }

    private static void browseNews() {
        for (; ; ) {
            System.out.println("hah,the nice music.");
            sleep(1);
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
