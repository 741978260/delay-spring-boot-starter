package com.mumu.pattern.template;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/11
 */
public abstract class AbstractAnimal {
    private final Object monitor = new Object();


    public void refresh(TestCallback action) {
        synchronized (this.monitor) {

        }
    }
}
