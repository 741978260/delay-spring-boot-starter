package com.mumu.concurrent.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/8/6
 */
public class ThreadPoolExample2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                new ThreadFactory() {
                    private final AtomicInteger threadNumber = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r, "customer-thread-" + threadNumber.getAndIncrement());
                        // 守护线程
                        if (t.isDaemon()) {
                            t.setDaemon(false);
                        }
                        //线程优先级
                        if (t.getPriority() != Thread.NORM_PRIORITY)
                            t.setPriority(Thread.NORM_PRIORITY);
                        /**
                         * 处理未捕捉的异常
                         */
                        t.setUncaughtExceptionHandler((t1, e) -> System.out.println(e.getMessage()));

                        return t;
                    }
                });
        for (int i = 0; i < 10; i++) {
            // 每3秒提交一个任务
            TimeUnit.SECONDS.sleep(3);
            threadPoolExecutor.execute(
                    () -> {
//                        try {
                        System.out.println(Thread.currentThread().getName());
//                            int i1 = 1 / 0;
//                        throw new RuntimeException("runtime exception...");
//                        } catch (Exception e) {
//                            System.out.println("子线程抛异常了");
//                        }
                    }
            );
        }
        threadPoolExecutor.shutdown();
        System.out.println("线程池关闭...");
    }


}
