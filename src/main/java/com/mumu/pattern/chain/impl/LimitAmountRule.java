package com.mumu.pattern.chain.impl;

import com.mumu.pattern.chain.Rule;
import com.mumu.pattern.chain.RuleChain;
import com.mumu.pattern.chain.input.RuleInput;
import com.mumu.pattern.chain.output.RuleOutput;
import lombok.extern.slf4j.Slf4j;
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
@Order(3)
public class LimitAmountRule implements Rule {
    @Override
    public void doRule(RuleInput input, RuleOutput output, RuleChain chain) {
        //执行业务逻辑，返回true表示规则通过
        boolean flag = limitAmount(input);
        //
        if (!flag) {
            //限量并超上限，通知，无需更新记录表、执行记录表状态（保持处理中状态，下一天处理）

            // 输出，结束流程
            setRejectResult(output);
            return;
        }
        // 下一步
        chain.doRule(input, output);
    }

    private void setRejectResult(RuleOutput output) {

    }

    private boolean limitAmount(RuleInput input) {
        return false;
    }
}
