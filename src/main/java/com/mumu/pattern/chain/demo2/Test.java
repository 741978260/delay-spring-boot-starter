package com.mumu.pattern.chain.demo2;

import lombok.extern.slf4j.Slf4j;
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

    public void test() {
        RuleExecuteChain chain = RuleExecuteChainFactory.getNamelistRuleExecuteChain();
        chain.execute(null, null);
    }
}
