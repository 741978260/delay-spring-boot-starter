package com.mumu.pattern.chain.demo2.input;

import lombok.Data;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/27
 */
@Data
public class RuleInput {
    /**
     * 名单id
     */
    private Long namelistId;
    /**
     * 执行ID
     */
    private Long executeId;

    /**
     * 用户中心注册id
     */
    private Long registerId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 批次号（任务标签+yyyyMMdd）
     */
    private String batchNo;
    /**
     * 业务日期 yyyyMMdd
     */
    private String businessDate;
    /**
     * 名单任务标签（双方约定）
     */
    private String taskLabel;
    /**
     * 序号
     */
    private String serialNo;
    /**
     * 名单类型
     *
     * @see com.vcredit.vmc.enums.NamelistTypeEnum
     */
    private String namelistType;
    /**
     * 名单来源
     *
     * @see com.vcredit.vmc.enums.NamelistSourceEnum
     */
    private Integer namelistSource;
    /**
     * 名单标签
     */
    private String namelistLabel;
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 客户名称
     */
    private String custName;
    /**
     * 身份证号
     */
    private String idNo;
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 任务状态：是否开启
     */
    private Integer taskStatus;
    /**
     * 任务策略
     */
    private Integer taskStrategy;
    /**
     * 限流数量
     */
    private Integer limitQuantity;
    /**
     * 是否覆盖
     */
    private Integer overwrite;
    /**
     * 去重天数
     */
    private Integer deduplicationDays;
}
