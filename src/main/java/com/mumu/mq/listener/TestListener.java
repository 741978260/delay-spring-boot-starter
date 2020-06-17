package com.mumu.mq.listener;

import com.mumu.mq.TestChannel;
import com.mumu.mq.message.TestData;
import net.dreamlu.mica.core.utils.$;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/17
 */
@Component
public class TestListener {

    @StreamListener(value = TestChannel.TEST_INPUT)
    public void process(Message message) {
        Object payload = message.getPayload();
        TestData data = $.readJson(String.valueOf(payload), TestData.class);
//        TestData data = (TestData) payload;
        System.out.println(data.getAge() + "::" + data.getName() + "::" + data.getSex());
    }

}
