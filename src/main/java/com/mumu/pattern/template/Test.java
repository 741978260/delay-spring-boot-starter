package com.mumu.pattern.template;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2020/5/11
 */
public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.refresh(() -> System.out.println("doInTest..."));
        System.out.println(cat);

        Dog dog = new Dog();
        dog.refresh(() -> System.out.println("do。。。"));
        System.out.println(dog);
    }
}
