package com.mumu.pattern.template;

import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/6/19
 */
@Service
public class NiiTestAImpl implements NiiTest {
    @Override
    public void test() {
        System.out.println("NiiTestAImpl");
    }
}
