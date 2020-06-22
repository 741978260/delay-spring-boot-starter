package com.mumu.pattern.chain.demo2.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleOutput {
    /**
     * 结果
     */
    private Boolean result;
    /**
     * 拒绝原因码
     */
    private String rejectCode;
    /**
     * 拒绝原因
     */
    private String rejectReason;
}
