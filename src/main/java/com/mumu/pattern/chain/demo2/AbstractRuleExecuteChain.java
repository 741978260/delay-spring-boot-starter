package com.mumu.pattern.chain.demo2;

import com.mumu.pattern.chain.demo2.input.RuleInput;
import com.mumu.pattern.chain.demo2.output.RuleOutput;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/22
 */
public abstract class AbstractRuleExecuteChain implements RuleExecuteChain {

    protected List<RuleExecute> executes;

    /**
     * 规则执行
     *
     * @param input  输入
     * @param output 输出
     */
    @Override
    public void execute(RuleInput input, RuleOutput output) {
        for (RuleExecute execute : executes) {
            if (Objects.equals(Boolean.FALSE, output.getResult())) {
                break;
            }
            execute.execute(input, output);
        }
    }
}
