package com.mumu.lock.demo;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/6/21
 */
public class DefaultExecute implements Execute {

    private final Sync sync;

    public DefaultExecute() {
        sync = new A();
    }

    @Override
    public void execute() {
        sync.execute();
    }

    abstract static class Sync {
        abstract void execute();
    }

    static final class A extends Sync {

        @Override
        void execute() {
            System.out.println("A...");
        }
    }

    static final class B extends Sync {

        @Override
        void execute() {
            System.out.println("B...");
        }
    }


}
