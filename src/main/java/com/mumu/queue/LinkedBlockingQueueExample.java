package com.mumu.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/11/7
 */
public class LinkedBlockingQueueExample {
    /**
     * 队列容量 要想支持阻塞功能，队列的容量一定是固定的，否则无法在入队的时候挂起线程
     */
    private final int capacity;

    private final AtomicInteger count = new AtomicInteger();

    public LinkedBlockingQueueExample() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingQueueExample(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<Integer>(9);
        LinkedBlockingQueueExample example = new LinkedBlockingQueueExample();
        final AtomicInteger count = example.count;
        final int andIncrement = count.getAndIncrement();
        System.out.println("开始：" + andIncrement);
//        System.out.println("count:" + count.get());
        System.out.println("之后：" + example.count);
    }
}
