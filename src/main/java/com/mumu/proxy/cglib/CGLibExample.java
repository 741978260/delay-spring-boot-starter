package com.mumu.proxy.cglib;

import com.mumu.proxy.jdk.ProxyExample;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/6/26
 */
public class CGLibExample {
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

    /**
     * CGLib代理类
     */
    static class CGLibProxy implements MethodInterceptor {
        private Object target;// 目标对象

        public Object getInstance(Object target) {
            this.target = target;
            Enhancer enhancer = new Enhancer();
            //设置父类为实例类
            enhancer.setSuperclass(this.target.getClass());
            //设置回调方法
            enhancer.setCallback(this);
            //创建代理对象
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("动态代理之前的业务处理");
            Object result = methodProxy.invokeSuper(o,objects);//执行调用方法（此方法执行前后，可以进行相关业务处理）
            return result;
        }

        //执行CGLib的方法调用
        public static void main(String[] args) {
            //构建CGLib代理类
            CGLibProxy proxy = new CGLibProxy();
            //初始化代理对象
            Car car = (Car) proxy.getInstance(new Taxi());
            //执行方法
            car.running();
        }
    }
}
