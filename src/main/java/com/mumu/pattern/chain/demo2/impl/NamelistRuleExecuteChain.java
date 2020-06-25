package com.mumu.pattern.chain.demo2.impl;

import com.mumu.pattern.chain.demo2.AbstractRuleExecuteChain;
import net.dreamlu.mica.config.SpringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/27
 */
@Service
public class NamelistRuleExecuteChain extends AbstractRuleExecuteChain {
    @PostConstruct
    private void init() {
        executes = Stream.of(
                SpringUtils.getBean(DeduplicationExecute.class),
                SpringUtils.getBean(OverwriteExecute.class),
                SpringUtils.getBean(LimitAmountExecute.class)
        ).collect(Collectors.toList());
    }

}
