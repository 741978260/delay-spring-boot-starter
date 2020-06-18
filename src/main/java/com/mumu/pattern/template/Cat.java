package com.mumu.pattern.template;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/11
 */
public class Cat extends AbstractAnimal {
    @Override
    protected void step3() {
        System.out.println("子类实现step3...");
    }

    @Override
    protected void step2() {
        System.out.println("子类方法step2...");
    }
}
