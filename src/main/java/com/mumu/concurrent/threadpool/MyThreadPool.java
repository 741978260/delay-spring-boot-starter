package com.mumu.concurrent.threadpool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Description 线程复用 演示
 * 生产 2个 worker 工作线程
 * 生产 10个 任务
 * @Author Created by Mumu
 * @Date on 2020/8/1
 */
public class MyThreadPool {

    LinkedList<Task> taskList = new LinkedList<>();

    private class Task { // 任务类
        private int id;

        public Task(int id) {
            this.id = id;
            System.out.println("第" + id + "个任务产生！");
        }

        public void run() {// 具体任务
            System.out.println("第" + id + "个任务正在执行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第" + id + "个任务执行完毕");
        }
    }

    class Worker extends Thread {//工人实体
        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (; ; ) {
                if (taskList.size() == 0) {
                    try {
                        synchronized (taskList) {
                            System.out.println("Worker " + name + "没有任务");
                            taskList.wait();// 没得到任务，进入tasklist的等待队列
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (taskList) {
                    System.out.println("Worker " + name + "得到任务");
                    taskList.removeFirst().run();
                }
            }
        }
    }

    void pool() {// 工人。只生产2个工人
        ArrayList<Worker> workerlist = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Worker k = new Worker("第" + (i + 1) + "个工人");
            k.start();
            workerlist.add(k);
        }
    }

    class Fartory extends Thread {//生产任务的线程 总共生产10个任务


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                synchronized (taskList) {
                    taskList.addFirst(new Task(i + 1));
                    taskList.notify();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool();
        myThreadPool.pool();// 初始化工人
        MyThreadPool.Fartory fartory = myThreadPool.new Fartory();
        fartory.start();
    }
}
