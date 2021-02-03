package com.mumu.base.abstractexample;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/1/16
 */
public interface PromotionRule {
    /**
     * 是否支持
     *
     * @param type 类型
     * @return 输出
     */
    boolean isSupport(String type);

    /**
     * 执行规则
     */
    void doRule();
}
