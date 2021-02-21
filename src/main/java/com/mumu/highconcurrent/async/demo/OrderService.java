package com.mumu.highconcurrent.async.demo;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/2/3
 */
public class OrderService implements RemoteLoader {
    @Override
    public String load() {
        this.delay();
        return "订单信息";
    }
}
