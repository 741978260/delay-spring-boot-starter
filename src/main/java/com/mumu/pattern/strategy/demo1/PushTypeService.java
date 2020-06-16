package com.mumu.pattern.strategy.demo1;

import com.mumu.pattern.strategy.demo1.dto.PushInputDTO;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/29
 */
public interface PushTypeService {
    /**
     * 推送名单信息
     *
     * @param inputDTO 入参
     */
    void push(PushInputDTO inputDTO);
}
