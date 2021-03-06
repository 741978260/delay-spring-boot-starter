package com.mumu.web;

import com.mumu.common.component.AtomicCounterResolver;
import com.mumu.pattern.template.Cat;
import com.mumu.service.TestService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/11
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/test/weixin")
    public UserInfo weixin() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenId("openid");
        return userInfo;
    }

    @Data
    public static class UserInfo {
        private String openId;
    }

    @GetMapping("/test")
    public void test() {
        testService.execute();
    }

    @GetMapping("/test666")
    public void test666() {
        testService.execute666();
    }

    @Autowired
    private AtomicCounterResolver atomicCounterResolver;

    @GetMapping("/test2")
    public void test2() {
        boolean flag = atomicCounterResolver.increment("test2", 10, 60);
        System.out.println(flag);
    }

    @Autowired
    private Cat cat;

    @GetMapping("/testCat")
    public void testCat() {
        cat.refresh(() -> System.out.println("doInTest..."));
    }
}
