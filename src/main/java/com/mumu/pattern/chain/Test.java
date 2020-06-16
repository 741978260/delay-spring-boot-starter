package com.mumu.pattern.chain;

import com.mumu.pattern.chain.impl.ApplicationDefaultRuleChain;
import com.mumu.pattern.chain.input.RuleInput;
import com.mumu.pattern.chain.output.RuleOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Test {
    @Autowired
    private ApplicationDefaultRuleChain ruleChain;

    public void test() {
        try {
            ruleChain.doRule(new RuleInput(), new RuleOutput());
        } finally {
            ruleChain.reset();
        }
    }
}
