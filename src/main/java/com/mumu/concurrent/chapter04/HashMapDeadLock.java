package com.mumu.concurrent.chapter04;

import java.util.HashMap;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/18
 */
public class HashMapDeadLock {
    /**
     *
     */
    private final HashMap<String, String> map = new HashMap<>();

    public void add(String key, String value) {
        this.map.put(key, value);
    }

    /**
     * 若运行该代码，记得保存手头的工作，该代码有可能导致你的电脑死机
     * HashMap 不具备线程安全的能力，如果想要使用线程安全的map 结构请使用ConcurrentHashMap 或者 使用Collections.synchronizedMap来代替
     */
    public static void main() {
        final HashMapDeadLock hmdl = new HashMapDeadLock();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 1; j < Integer.MAX_VALUE; j++) {
                    hmdl.add(String.valueOf(j), String.valueOf(j));
                }
            }).start();
        }
    }
}
