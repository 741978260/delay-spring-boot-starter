package com.mumu.pattern.strategy.demo1;

import com.mumu.pattern.strategy.demo1.dto.PushInputDTO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/16
 */
@Service
public class PushTest {
    private PushTypeFactory pushTypeFactory;

    public void test() {
        //mode，system 可配置
        String mode = "sync";
        String system = "product";
        // 匹配对应推送处理类
        PushTypeService pushTypeService = pushTypeFactory.selectType(mode, system).orElseThrow(() -> new RuntimeException("未找到对应推送处理类！"));
        pushTypeService.push(new PushInputDTO());
    }
}
