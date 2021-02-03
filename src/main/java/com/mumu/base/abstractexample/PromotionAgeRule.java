package com.mumu.base.abstractexample;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/1/16
 */
@Component
public class PromotionAgeRule extends AbstractPromotionRule {


    @Override
    public boolean isSupport(String type) {
        return Objects.equals("SMS000003", type);
    }

    @Override
    public void doRule() {
        System.out.println("执行年龄规则...");
    }
}
