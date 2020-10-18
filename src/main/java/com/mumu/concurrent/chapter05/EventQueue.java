package com.mumu.concurrent.chapter05;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;

/**
 * @Description 单线程通信，就是一个生产者，一个消费者，没问题；如果多个线程同时进行take 或者 offer ,就会出现问题：
 * 大致分为两种：1、linkedlist 中没有元素的时候，仍旧调用了removeFirst方法，其二 LinkedList中的元素超过10个的时候，仍旧调用了addLast方法
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class EventQueue {

    private final int max;

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    static class Event {
    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();
    private final Object o = new Object();

    public void offer(Event event) {
        // 多线程 争抢同一个 EventQueue对象 的 同一个eventQueue属性；作用同synchronized (o)
//        synchronized (o) {
        synchronized (eventQueue) {
            if (eventQueue.size() >= max) {
                try {

                    console(" the queue is full.");
                    // wait 和 sleep 方法都可以使线程进入阻塞状态
                    // wait 和 sleep 方法都是可中断方法，被中断后都会收到中断异常
                    // wait是Object的方法，sleep是Thread特有的方法
                    // wait方法的执行必须在同步方法中进行，而sleep则不需要；
                    // wait方法会释放monitor的锁，而sleep方法不会
                    // sleep方法短暂休眠之后会主动退出阻塞，而wait方法（没有指定wait时间）则需要被其他线程中断后才能退出阻塞

                    // 用哪个对象的monitor进行同步，就只能用哪个对象进行wait 和 notify 操作
                    // 线程执行了某个对象的wait方法以后，会加入与之对应的wait set中，每一个对象的monitor都有一个与之关联的wait set
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console(" the new event is submitted");
            eventQueue.addLast(event);
            // 唤醒单个正在执行该对象wait方法的线程
            // 如果有某个线程由于执行该对象的wait方法而进入阻塞则会被唤醒，如果没有则会忽略
            // 被唤醒的线程需要重新获取对该对象所关联monitor的锁才能继续执行
            eventQueue.notify();
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            if (eventQueue.isEmpty()) {
                try {
                    console(" the queue is empty.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            console(" the event " + event + " is handled.");
            return event;
        }
    }

    private void console(String message) {
        System.out.printf("%s:%s\n", currentThread().getName(), message);
    }
}
