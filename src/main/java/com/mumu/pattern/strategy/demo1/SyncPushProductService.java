package com.mumu.pattern.strategy.demo1;

import com.mumu.pattern.strategy.demo1.dto.PushInputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/16
 */
@Slf4j
@Service
@PushType(PushTypeEnum.SYNC_PRODUCT)
public class SyncPushProductService implements PushTypeService {
    @Override
    public void push(PushInputDTO inputDTO) {
        System.out.println("同步推送产品端...");
    }
}
