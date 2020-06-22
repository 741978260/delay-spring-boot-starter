package com.mumu.pattern.template;

import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/11
 */
@Service
public class Dog extends AbstractAnimal {
    @Override
    protected void step3() {
        System.out.println("子类实现step3...");
    }
}
