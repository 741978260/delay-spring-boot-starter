package com.mumu.pattern.chain;

import com.mumu.pattern.chain.input.RuleInput;
import com.mumu.pattern.chain.output.RuleOutput;

/**
 * <p>
 * 规则链
 * </p>
 *
 * @author cailin
 * @since 2020/6/10
 */
public interface RuleChain {
    /**
     * 规则执行
     *
     * @param input  输入
     * @param output 输出
     */
    void doRule(RuleInput input, RuleOutput output);
}
