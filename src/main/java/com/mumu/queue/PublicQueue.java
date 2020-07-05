package com.mumu.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description 公共缓存队列
 * 只做两件事：（1）生产；（2）消费
 * @Author Created by Mumu
 * @Date on 2020/7/5
 */
public class PublicQueue<T> {
    //    private BlockingQueue<T> blockingQueue = new LinkedBlockingQueue(50);//缓存区
    private BlockingDeque<T> blockingDeque = new LinkedBlockingDeque<>(50);

    public void add(T msg) {
        try {
            blockingDeque.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产一个产品，当前商品角标为：" + "===文本为：" + msg);
    }

    public T remove() {

        T t = null;
        try {
            t = blockingDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("消费一个产品，当前商品角标为：" + "===文本为：" + t);
        return t;
    }
}
