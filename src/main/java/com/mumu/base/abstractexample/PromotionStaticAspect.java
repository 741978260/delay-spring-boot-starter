package com.mumu.base.abstractexample;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2021/1/16
 */
public abstract class PromotionStaticAspect implements InitializingBean {
    @Autowired
    protected List<PromotionRule> filters;

    private List<String> matchFilters;

    public void setMatchFilters(List<String> matchFilters) {
        this.matchFilters = matchFilters;
    }

    @Override
    public void afterPropertiesSet() {
        List<PromotionRule> qualifiedFilters = new ArrayList<>();
        if (!CollectionUtils.isEmpty(matchFilters)) {
            for (String matchFilter : matchFilters) {
                final PromotionRule promotionRule = filters.stream().filter(f -> f.isSupport(matchFilter)).findFirst().orElse(null);
                if (Objects.nonNull(promotionRule)) {
                    qualifiedFilters.add(promotionRule);
                }
            }
        }
        filters.clear();
        filters = qualifiedFilters;
    }

    protected abstract boolean handleMessageBefore();
}
