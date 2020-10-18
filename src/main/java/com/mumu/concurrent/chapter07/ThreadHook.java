package com.mumu.concurrent.chapter07;

import java.util.concurrent.TimeUnit;

/**
 * @Description Hook线程只有在收到退出信号的时候才会被执行，如果在kill的时候使用了参数-9 ，那么hook线程不会得到执行，进程将会立即退出
 * 因此.lock文件将得不到清理。Hook线程中也可以执行一下资源释放的工作，比如关闭文件句柄、socket连接、数据库connection等
 * 尽量不要在hook线程中执行一些耗时非常长的操作，因为会导致程序迟迟不能退出。
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class ThreadHook {
    public static void main(String[] args) {
        // 为应用程序注入钩子线程
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("the hook thread 1 is running.");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the hook thread 1 will exit.");
        }));

        // 钩子线程可以注册多个
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("the hook thread 2 is running.");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the hook thread 2 will exit.");
        }));

        System.out.println("the program will is stopping.");
    }
}
