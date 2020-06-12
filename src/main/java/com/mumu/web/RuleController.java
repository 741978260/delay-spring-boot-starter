package com.mumu.web;

import com.mumu.drools.DroolsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/11
 */
@RestController
@RequestMapping("/rule")
public class RuleController {
    @Resource
    private DroolsService droolsService;

    @RequestMapping("/param")
    public void param() {
        droolsService.doTest();
    }

    @GetMapping("/customer")
    public void customer() {
        droolsService.doCustomer();
    }
}
