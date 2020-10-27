package com.mumu.concurrent.chapter15;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/27
 */
@FunctionalInterface
public interface Task<T> {
    // 任务执行接口，该接口允许有返回值
    T call();
}
