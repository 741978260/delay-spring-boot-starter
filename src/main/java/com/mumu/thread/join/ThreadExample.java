package com.mumu.thread.join;

/**
 * @Description join()：在一个线程中，调用other.join(),这时候当前线程会让出执行权给other线程，直到other线程执行完，或者过了超时时间之后，再继续执行当前线程，
 * 从源码可以看出，join底层还是通过wait()方法来实现
 * @Author Created by Mumu
 * @Date on 2020/6/20
 */
public class ThreadExample {


    /**
     * 未使用join，主子线程交替执行
     * 加入join方法，
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程"+Thread.currentThread().getName()+"睡眠：" + i + "秒。");

            }
        });
        thread.start();//开启线程
        thread.join(2000);//等待子线程先执行2秒钟，之后再主子线程交替执行

        // 主线程执行
        for (int i = 1; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程"+Thread.currentThread().getName()+"睡眠：" + i + "秒。");
        }

    }

}
