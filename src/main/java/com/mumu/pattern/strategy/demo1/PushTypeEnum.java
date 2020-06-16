package com.mumu.pattern.strategy.demo1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/29
 */
@Getter
@AllArgsConstructor
public enum PushTypeEnum {
    /**
     * http同步推送产品端
     */
    SYNC_PRODUCT("sync", "product", "http同步推送产品端");

    /**
     * 方式
     */
    private String mode;
    /**
     * 系统
     */
    private String system;
    /**
     * 描述
     */
    private String desc;

    /**
     * 获取枚举
     *
     * @param mode   方式
     * @param system 系统
     *
     * @return 枚举
     */
    public static PushTypeEnum getPushTypeEnum(String mode, String system) {
        return Stream.of(values())
                .filter(t -> t.getMode().equals(mode) && t.getSystem().equals(system))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("根据mode和system无法匹配到对应的PushTypeEnum！"));
    }
}
