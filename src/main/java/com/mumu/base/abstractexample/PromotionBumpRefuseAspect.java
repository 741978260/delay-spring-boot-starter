package com.mumu.base.abstractexample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/1/16
 */
@Component
public class PromotionBumpRefuseAspect extends PromotionStaticAspect {

    public PromotionBumpRefuseAspect() {
        setMatchFilters(Arrays.asList("SMS000003", "SMS000007"));
//        afterPropertiesSet();
    }


    @Override
    protected boolean handleMessageBefore() {
        filters.forEach(PromotionRule::doRule);
        return false;
    }
}
