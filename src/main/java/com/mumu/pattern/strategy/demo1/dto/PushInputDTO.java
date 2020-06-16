package com.mumu.pattern.strategy.demo1.dto;

import lombok.Data;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/29
 */
@Data
public class PushInputDTO {
    /**
     * 名单id
     */
    private Long namelistId;
    /**
     * 执行ID
     */
    private Long executeId;
    /**
     * 批次号（任务标签+yyyyMMdd）
     */
    private String batchNo;
    /**
     * 序号
     */
    private String serialNo;
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
     * 用户中心注册id
     */
    private Long registerId;
    /**
     * 用户id
     */
    private Long userId;
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
}
