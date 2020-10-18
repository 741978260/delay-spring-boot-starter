package com.mumu.concurrent.chapter05;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;

/**
 * @Description 多线程通信，如果多个线程同时进行take 或者 offer ,就会出现问题：
 * 大致分为两种：1、linkedlist 中没有元素的时候，仍旧调用了removeFirst方法，其二 LinkedList中的元素超过10个的时候，仍旧调用了addLast方法
 * 解决办法：只需要将临界值的判断if改为while，将notify改为notifyAll即可
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class EventQueue2 {

    private final int max;

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue2() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue2(int max) {
        this.max = max;
    }

    static class Event {
    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    public void offer(Event event) {
        synchronized (eventQueue) {
            // 主要与单线程通信案列中的 if判断的差别！！！！
            while (eventQueue.size() >= max) {
                try {

                    console(" the queue is full.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console(" the new event is submitted");
            eventQueue.addLast(event);
            eventQueue.notifyAll();
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            // 主要与单线程通信案列中的 if判断的差别！！！！
            while (eventQueue.isEmpty()) {
                try {
                    console(" the queue is empty.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Event event = eventQueue.removeFirst();
            this.eventQueue.notifyAll();
            console(" the event " + event + " is handled.");
            return event;
        }
    }

    private void console(String message) {
        System.out.printf("%s:%s\n", currentThread().getName(), message);
    }
}
