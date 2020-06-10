package com.mumu.pattern.chain;

import com.mumu.pattern.chain.input.RuleInput;
import com.mumu.pattern.chain.output.RuleOutput;

/**
 * <p>
 * 规则
 * </p>
 *
 * @author cailin
 * @since 2020/6/10
 */
public interface Rule {
    /**
     * 执行规则
     *
     * @param input  输入
     * @param output 输出
     * @param chain  规则链
     */
    void doRule(RuleInput input, RuleOutput output, RuleChain chain);
}
