package com.mumu;

import com.mumu.mq.TestChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/4
 */
@EnableBinding({TestChannel.class})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
