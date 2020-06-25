package com.mumu.pattern.chain.demo2.impl;

import com.mumu.pattern.chain.demo2.AbstractRuleExecute;
import com.mumu.pattern.chain.demo2.input.RuleInput;
import com.mumu.pattern.chain.demo2.output.RuleOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 覆盖操作
 * </p>
 *
 * @author cailin
 * @since 2020/5/27
 */
@Slf4j
@Service
public class OverwriteExecute extends AbstractRuleExecute {

    /**
     * 设置拒绝结果
     *
     * @param output 输出
     */
    @Override
    protected void setRejectResult(RuleOutput output) {
    }

    /**
     * 是否需要执行业务更新，//已被覆盖，执行控制记录失效状态，通知，更新记录表、执行记录表状态
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
     * 是否覆盖，返回true表示规则通过
     *
     * @param input 输入
     *
     * @return 输出，返回true表示规则通过
     */
    @Override
    protected boolean doRule(RuleInput input) {
        return true;
    }

    /**
     * 保存并且覆盖如果需要
     *
     * @param entity    实体
     * @param overwrite 是否覆盖
     *
     * @return 执行控制记录
     */
//    @RedisLock(value = RedisLockConstants.INSERT_EXECUTE_CONTROL_INFO_LOCK, param = "#entity.batchNo")
//    public NamelistExecuteControl saveAndOverwriteIfNecessary(NamelistExecuteControl entity, Integer overwrite) {
//    }

    /**
     * 更新数据
     *
     * @param entity    实体
     * @param overwrite 是否覆盖
     *
     * @return 执行控制记录
     */
//    @Transactional(rollbackFor = Exception.class)
//    public NamelistExecuteControl updateData(NamelistExecuteControl entity, boolean overwrite) {
//    }

    /**
     * 根据批次号查询
     *
     * @param batchNo 批次号
     *
     * @return 执行控制记录
     */
//    public NamelistExecuteControl findByBatchNo(String batchNo) {
//        Optional<NamelistExecuteControl> optional = namelistExecuteControlDAO.findByBatchNo(batchNo);
//        return optional.orElse(null);
//    }
}
