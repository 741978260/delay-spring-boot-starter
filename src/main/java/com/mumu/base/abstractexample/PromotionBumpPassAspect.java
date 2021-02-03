package com.mumu.base.abstractexample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/1/16
 */
@Component
public class PromotionBumpPassAspect extends PromotionStaticAspect {

    public PromotionBumpPassAspect() {
        setMatchFilters(Collections.singletonList("SMS000003"));
//        afterPropertiesSet();
    }


    @Override
    protected boolean handleMessageBefore() {
        filters.forEach(PromotionRule::doRule);
        return false;
    }
}
