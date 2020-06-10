package com.mumu.web;

import com.mumu.common.component.AtomicCounterResolver;
import com.mumu.service.TestService;
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

    @GetMapping("/test")
    public void test() {
        testService.execute();
    }

    @Autowired
    private AtomicCounterResolver atomicCounterResolver;

    @GetMapping("/test2")
    public void test2() {
        boolean flag = atomicCounterResolver.increment("test2", 10, 60);
        System.out.println(flag);
    }
}
