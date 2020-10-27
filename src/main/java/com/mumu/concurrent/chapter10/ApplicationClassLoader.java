package com.mumu.concurrent.chapter10;

import com.rabbitmq.tools.json.JSONUtil;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/20
 */
public class ApplicationClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }
}
