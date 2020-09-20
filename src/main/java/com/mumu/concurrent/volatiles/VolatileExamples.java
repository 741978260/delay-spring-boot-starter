package com.mumu.concurrent.volatiles;

/**
 * @Description volatile 示例
 * @Author Created by Mumu
 * @Date on 2020/9/20
 */
public class VolatileExamples {
    private static volatile
            boolean running = true;

    public static void main(String[] args) {

        new Thread(() -> {
            while (running) {
                // do sth
            }
            System.out.println("end");

        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        running = false;

    }

}
