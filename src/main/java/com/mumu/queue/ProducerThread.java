package com.mumu.queue;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/5
 */
public class ProducerThread extends Thread {
    private PublicQueue3 publicQueue;

    public ProducerThread(PublicQueue3 publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            publicQueue.add(String.valueOf(i));
        }
    }
}
