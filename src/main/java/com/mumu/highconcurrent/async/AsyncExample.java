package com.mumu.highconcurrent.async;

import com.mumu.concurrent.chapter08.ThreadPool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/12/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncExample {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    // 案例一：CountDownLatch
    @Test
    public void example1() throws InterruptedException {
        long start = System.currentTimeMillis();
        // 并发控制器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            final int n = i + 1;
            taskExecutor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("当前线程：" + Thread.currentThread().getName() + ",执行业务:" + n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        // 阻塞直到所有线程执行结束
        countDownLatch.await();
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    // //使用Future方式执行多任务
    @Test
    public void example2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        //生成一个集合
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final int n = i + 1;
            final Future<?> future = taskExecutor.submit(() -> {
                try {
                    return output(n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 0;
            });
            futures.add(future);
        }
        for (Future future : futures) {
//            int result = (int) future.get();
            while (true) {
                if (future.isDone() && !future.isCancelled()) {
                    int result = (int) future.get();
                    list.add(result);
                    break; //当前future获取结果完毕，跳出while
                } else {
                    Thread.sleep(1);//每次轮询休息1毫秒（CPU纳秒级），避免CPU高速轮循耗空CPU---》新手别忘记这个
                }
            }
        }
        System.out.println("结果：" + Arrays.toString(list.toArray()));
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    private int output(int n) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("当前线程：" + Thread.currentThread().getName() + ",执行业务:" + n);
        return n;
    }
}

