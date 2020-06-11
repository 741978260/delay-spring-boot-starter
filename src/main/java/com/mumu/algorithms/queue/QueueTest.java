package com.mumu.algorithms.queue;

import java.util.PriorityQueue;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/10
 */
public class QueueTest {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(11);
        priorityQueue.add(5);
        priorityQueue.add(76);
        priorityQueue.add(4);
        priorityQueue.add(9);
        priorityQueue.add(8);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }


    }
}
