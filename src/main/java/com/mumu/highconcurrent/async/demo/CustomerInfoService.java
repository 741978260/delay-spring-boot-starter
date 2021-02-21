package com.mumu.highconcurrent.async.demo;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/2/3
 */
public class CustomerInfoService implements RemoteLoader {
    @Override
    public String load() {
        this.delay();
        return "基础信息";
    }
}
