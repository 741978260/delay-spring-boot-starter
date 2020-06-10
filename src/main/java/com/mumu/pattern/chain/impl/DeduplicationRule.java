package com.mumu.pattern.chain.impl;

import com.mumu.pattern.chain.Rule;
import com.mumu.pattern.chain.RuleChain;
import com.mumu.pattern.chain.input.RuleInput;
import com.mumu.pattern.chain.output.RuleOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/10
 */
@Slf4j
@Service
@Order(1)
public class DeduplicationRule implements Rule {
    @Override
    public void doRule(RuleInput input, RuleOutput output, RuleChain chain) {
        // 执行业务逻辑，返回true表示规则通过
        boolean flag = deduplication(input);
        //
        if (!flag) {
            //有重复，通知，更新记录表、执行记录表状态
            // 更新记录表、执行记录表状态
            ((DeduplicationRule) AopContext.currentProxy()).updateData(input);
            // 输出，结束流程
            setRejectResult(output);
            return;
        }
        // 下一步
        chain.doRule(input, output);
    }

    private void updateData(RuleInput input) {

    }

    private void setRejectResult(RuleOutput output) {

    }

    private boolean deduplication(RuleInput input) {
        return false;
    }
}
