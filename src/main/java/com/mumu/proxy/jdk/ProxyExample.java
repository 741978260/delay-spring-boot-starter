package com.mumu.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description JDK Proxy相关示例
 * @Author Created by Mumu
 * @Date on 2020/6/26
 */
public class ProxyExample {
    static interface Car {
        void running();
    }

    static class Bus implements Car {

        @Override
        public void running() {
            System.out.println("The Bus is running");
        }

    }

    static class Taxi implements Car {

        @Override
        public void running() {
            System.out.println("The Taxi is running");
        }

    }

    static class JDKProxy implements InvocationHandler {
        private Object target; //目标对象

        // 获取到代理对象
        public Object getInstance(Object target) {
            this.target = target;
            // 获得代理对象
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        /**
         * 执行代理方法
         *
         * @param proxy  代理对象
         * @param method 代理方法
         * @param args   方法的参数
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("动态代理之前的业务处理");
            Object result = method.invoke(target, args);//执行调用方法（此方法执行前后，可以进行相关业务处理）
            return result;
        }

        public static void main(String[] args) {
            JDKProxy jdkProxy = new JDKProxy();
            Car carInstance = (Car) jdkProxy.getInstance(new Taxi());
            carInstance.running();
        }
    }
}

