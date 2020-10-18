package com.mumu.service.impl;

import com.mumu.service.TestService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/4
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public synchronized void execute() {
        System.out.println("hello execute()...");
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void execute666() {
        System.out.println("hello execute666()...");
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
