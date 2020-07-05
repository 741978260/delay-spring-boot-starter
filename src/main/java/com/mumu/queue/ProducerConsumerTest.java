package com.mumu.queue;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/5
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        PublicQueue3 publicQueue = new PublicQueue3();
        ProducerThread producerThread = new ProducerThread(publicQueue);
        ConsumerThread consumerThread = new ConsumerThread(publicQueue);
        producerThread.start();
        consumerThread.start();
    }
}
