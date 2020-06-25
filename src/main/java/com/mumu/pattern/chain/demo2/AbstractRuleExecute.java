package com.mumu.pattern.chain.demo2;

import com.mumu.pattern.chain.demo2.input.RuleInput;
import com.mumu.pattern.chain.demo2.output.RuleOutput;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/22
 */
public abstract class AbstractRuleExecute implements RuleExecute {

    /**
     * 规则执行
     *
     * @param input  输入
     * @param output 输出
     */
    @Override
    public void execute(RuleInput input, RuleOutput output) {
        // 执行业务逻辑，返回true表示规则通过
        boolean flag = doRule(input);
        //
        if (!flag) {
            //更新记录表、执行记录表状态
            if (isNeedUpdate()) {
                updateData(input);
            }

            // 输出，结束流程
            setRejectResult(output);
        }
    }

    /**
     * 返回true表示规则通过 （默认通过）
     *
     * @param input 输入
     *
     * @return 结果
     */
    protected boolean doRule(RuleInput input) {
        return true;
    }

    /**
     * 是否需要执行业务更新 （默认不需要）
     *
     * @return 结果
     */
    protected boolean isNeedUpdate() {
        return false;
    }

    /**
     * 数据更新
     *
     * @param input 输入
     */
    protected void updateData(RuleInput input) {

    }

    /**
     * 设置拒绝结果
     *
     * @param output 输出
     */
    protected void setRejectResult(RuleOutput output) {

    }
}
