package com.mumu.pattern.chain.demo2.impl;

import com.mumu.pattern.chain.demo2.AbstractRuleExecute;
import com.mumu.pattern.chain.demo2.input.RuleInput;
import com.mumu.pattern.chain.demo2.output.RuleOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * B类去重（多少天内不能重复推）
 * </p>
 *
 * @author cailin
 * @since 2020/5/27
 */
@Slf4j
@Service
public class DeduplicationExecute extends AbstractRuleExecute {

    /**
     * 设置拒绝结果
     *
     * @param output 输出
     */
    @Override
    protected void setRejectResult(RuleOutput output) {
//        output.setResult(Boolean.FALSE);
//        output.setRejectCode(RuleExecuteRejectTypeEnum.DUPLICATE.getCode());
//        output.setRejectReason(RuleExecuteRejectTypeEnum.DUPLICATE.getDesc());
    }

    /**
     * 是否需要执行业务更新，//有重复，通知，更新记录表、执行记录表状态
     *
     * @return 结果
     */
    @Override
    protected boolean isNeedUpdate() {
        return true;
    }

    /**
     * 数据更新
     *
     * @param input 输入
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateData(RuleInput input) {
    }

    /**
     * B类去重（多少天内不能重复推），返回true表示规则通过
     *
     * @param input 输入
     *
     * @return 输出，返回true表示规则通过
     */
    @Override
    protected boolean doRule(RuleInput input) {
        return true;
    }
}


