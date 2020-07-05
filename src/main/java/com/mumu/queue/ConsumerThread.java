package com.mumu.queue;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/5
 */
public class ConsumerThread extends Thread {
    private PublicQueue3 publicQueue;

    public ConsumerThread(PublicQueue3 publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for (; ; ) {
            publicQueue.remove();
        }
    }
}
