package com.mumu.calculation;

/**
 * @Description 按位与 按位或
 * @Author Created by Mumu
 * @Date on 2020/8/11
 */
public class CalculateExample {
    public static void main(String[] args) {
        /**
         * & 运算规则：两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0
         */
        System.out.println("3&5: " + (3 & 5));
        /**
         * | 运算规则：两个数都转为二进制，然后从高位开始比较，两个数只要有一个为1则为1，否则就为0。
         */
        System.out.println("3|5: " + (3 | 5));

        System.out.println("3&0: " + (3 & 0));
        System.out.println("3|0: " + (3 | 0));

        /**
         * 左移运算符
         */
        System.out.println("5 << 2 : " + (5 << 2));
        /**
         * 右移运算符
         */
        System.out.println("5 >> 2 : " + (5 >> 2));
        System.out.println(9 / 4);


    }
}
