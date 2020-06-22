package com.mumu.pattern.chain.demo2;

import com.mumu.pattern.chain.demo2.input.RuleInput;
import com.mumu.pattern.chain.demo2.output.RuleOutput;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/27
 */
public interface RuleExecute {
    /**
     * 规则执行
     *
     * @param input  输入
     * @param output 输出
     */
    void execute(RuleInput input, RuleOutput output);
}
