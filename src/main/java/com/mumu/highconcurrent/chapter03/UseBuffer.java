package com.mumu.highconcurrent.chapter03;

import java.nio.IntBuffer;

/**
 * @Description Buffer类是一个非线程安全类
 * (1) 使用创建子类实例对象的allocate()方法，创建一个Buffer类的实例对象
 * (2) 调用put方法，将数据写入到缓冲区中
 * （3）写入完成后，在开始读取数据前，调用Buffer.flip()方法，将缓冲区转换为读模式
 * （4）调用get方法，从缓冲区读取数据
 * （5）读取完成后，调用Buffer.clear()或者Buffer.compact()方法，将缓冲区转换为写入模式
 * @Author Created by Mumu
 * @Date on 2020/12/6
 */
public class UseBuffer {
    static IntBuffer intBuffer = null;

    /*allocate()创建缓冲区*/
    public static void allocateTest() {
        //调用allocate方法，而不是使用new
        intBuffer = IntBuffer.allocate(20);

        System.out.println("-----------after allocate------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }

    /*写入到缓冲区*/
    public static void putTest() {
        for (int i = 0; i < 5; i++) {
            // 写入一个整数到缓冲区
            intBuffer.put(i);
        }
        System.out.println("-----------after put------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }

    /*flip()翻转*/
    public static void flipTest() {
        // 翻转缓冲区，从写模式翻转成读模式
        intBuffer.flip();

        System.out.println("-----------after flip------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }

    /*get()从缓冲区读取*/
    public static void getTest() {
        // 先读2个
        for (int i = 0; i < 2; i++) {
            final int j = intBuffer.get();
            System.out.println("j = " + j);
        }

        System.out.println("-----------after get 2 int------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());

        // 再读3个
        for (int i = 0; i < 3; i++) {
            int j = intBuffer.get();
            System.out.println("j = " + j);
        }
        System.out.println("-----------after get 3 int------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }

    /*rewind倒带*/
    public static void rewindTest() {
        intBuffer.rewind();
        System.out.println("-----------after rewind------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }

    public static void reRead() {
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                // 临时保存，标记一下第3个位置
                intBuffer.mark();
            }
            int j = intBuffer.get();
            System.out.println("j = " + j);
        }
        System.out.println("-----------after reRead------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }

    public static void afterReset() {
        System.out.println("-----------after reset------------");
        // 把前面保存在mark中的值恢复到position
        intBuffer.reset();
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
        for (int i = 2; i < 5; i++) {
            int j = intBuffer.get();
            System.out.println("j = " + j);
        }
    }

    /*clear()清空缓冲区*/
    public static void clearDemo() {
        System.out.println("-----------after clear------------");
        // 清空缓冲区，进入写入模式
        intBuffer.clear();
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }

    public static void main(String[] args) {
        allocateTest();
        putTest();
        flipTest();
        getTest();
        rewindTest();
        reRead();
        afterReset();
        clearDemo();
    }
}
