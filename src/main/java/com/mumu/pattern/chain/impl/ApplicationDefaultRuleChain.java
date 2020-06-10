package com.mumu.pattern.chain.impl;

import com.mumu.pattern.chain.Rule;
import com.mumu.pattern.chain.RuleChain;
import com.mumu.pattern.chain.input.RuleInput;
import com.mumu.pattern.chain.output.RuleOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/10
 */
@Slf4j
@Service
public class ApplicationDefaultRuleChain implements RuleChain {

    /**
     * 当前执行rule的offset,线程安全
     */
    private final ThreadLocal<Integer> pos = ThreadLocal.withInitial(() -> 0);

    // 根据指定@Order排好序了
    @Autowired
    private List<Rule> rules;

    /**
     * 规则执行
     *
     * @param input  输入
     * @param output 输出
     */
    @Override
    public void doRule(RuleInput input, RuleOutput output) {
        int counter = pos.get();
        try {
            if (counter < rules.size()) {
                Rule rule = rules.get(counter);
                pos.set(counter + 1);
                // 传递this 链
                rule.doRule(input, output, this);
            }
        } catch (Exception e) {
            pos.remove();
        } finally {
            // todo 这里有问题
            if (counter >= rules.size()) {
                pos.remove();
            }
        }
        // todo 执行链全部执行完，最后返回有问题
    }
}
