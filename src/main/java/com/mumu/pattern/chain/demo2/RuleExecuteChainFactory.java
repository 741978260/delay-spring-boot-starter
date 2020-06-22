package com.mumu.pattern.chain.demo2;

import com.mumu.pattern.chain.demo2.impl.NamelistRuleExecuteChain;
import net.dreamlu.mica.config.SpringUtils;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/22
 */
public class RuleExecuteChainFactory {
    private RuleExecuteChainFactory() {
    }

    /**
     * 获取白名单规则执行链
     *
     * @return 结果
     */
    public static RuleExecuteChain getNamelistRuleExecuteChain() {
        return SpringUtils.getBean(NamelistRuleExecuteChain.class);
    }
}
