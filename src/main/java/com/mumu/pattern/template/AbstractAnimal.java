package com.mumu.pattern.template;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/11
 */
public abstract class AbstractAnimal {
    @Autowired
    private List<NiiTest> tests;

    private final Object monitor = new Object();


    public void refresh(TestCallback action) {
        synchronized (this.monitor) {
            step1();
            step2();// 钩子方法
            step3();// 抽象方法
            System.out.println("tests个数：" + tests.size());
        }
    }

    protected abstract void step3();

    protected void step2() {
        System.out.println("父类方法step2...");
    }

    private void step1() {
        System.out.println("父类方法step1...");
    }
}
