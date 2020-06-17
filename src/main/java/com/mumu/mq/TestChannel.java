package com.mumu.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/17
 */
public interface TestChannel {
    String TEST_INPUT = "testInput";

    @Input(TEST_INPUT)
    SubscribableChannel testInput();
}
