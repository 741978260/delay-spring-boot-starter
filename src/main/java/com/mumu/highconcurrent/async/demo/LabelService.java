package com.mumu.highconcurrent.async.demo;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/2/3
 */
public class LabelService implements RemoteLoader {
    @Override
    public String load() {
        this.delay();
        return "标签信息";
    }
}
