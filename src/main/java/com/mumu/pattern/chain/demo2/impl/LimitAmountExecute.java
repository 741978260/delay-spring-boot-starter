package com.mumu.pattern.chain.demo2.impl;

import com.mumu.pattern.chain.demo2.AbstractRuleExecute;
import com.mumu.pattern.chain.demo2.input.RuleInput;
import com.mumu.pattern.chain.demo2.output.RuleOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/27
 */
@Slf4j
@Service
public class LimitAmountExecute extends AbstractRuleExecute {
//    @Autowired
//    private AtomicCounterResolver atomicCounterResolver;
//    @Autowired
//    private PollingMessageResolver pollingMessageResolver;
//    @Autowired
//    private NamelistChannel namelistChannel;

    /**
     * 设置拒绝结果
     *
     * @param output 输出
     */
    @Override
    protected void setRejectResult(RuleOutput output) {
//        output.setResult(Boolean.FALSE);
//        output.setRejectCode(RuleExecuteRejectTypeEnum.LIMIT_AMOUNT.getCode());
//        output.setRejectReason(RuleExecuteRejectTypeEnum.LIMIT_AMOUNT.getDesc());
    }

    /**
     * 限制数量，返回true表示规则通过
     *
     * @param input 输入
     *
     * @return 输出，返回true表示规则通过
     */
    @Override
    protected boolean doRule(RuleInput input) {
//         需要限量
//        if (Objects.equals(NamelistTaskStrategyEnum.LIMIT_NUMBER.getCode(), input.getTaskStrategy())) {
        // 工具
//            boolean flag = atomicCounterResolver.increment(
//                    String.format("%s%s", RedisLockConstants.TASK_LABEL_LIMIT_AMOUNT_LOCK, DateUtils.dateToString(new Date(), DateUtils.DATE_PATTERN_YYMMDD)),
//                    input.getLimitQuantity(),
//                    24 * 60 * 60);
        // 超最大限量了
//            if (!flag) {
//                log.info("[{}-{}]转移至24小时延时队列", input.getBatchNo(), input.getIdNo());
        // 转移至24小时延时队列
//                try {
//                    AddLoanWhitelistNamelistMessage message = new AddLoanWhitelistNamelistMessage();
//                    BeanUtils.copyProperties(input, message);
//                    namelistChannel.oneDayDelayOutput().send(pollingMessageResolver.create(message));
        // 输出 false
//                    return false;
//                } catch (Exception e) {
//                    log.info("{}", e.getMessage());
//                }
//            }
//        }
        // 不限量 或者 限量未超上限
        return true;
    }
}
