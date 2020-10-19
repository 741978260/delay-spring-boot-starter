package com.mumu.concurrent.chapter08;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/19
 */
public class RunnableDenyException extends RuntimeException {
    public RunnableDenyException(String s) {
        super(s);
    }
}
