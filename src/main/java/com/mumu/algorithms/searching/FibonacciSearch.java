package com.mumu.algorithms.searching;

/**
 * @Description 裴波那契查找，它是利用了黄金分割原理来实现的，我们需要现有一个裴波那契数列的数组
 * @Author Created by Mumu
 * @Date on 2020/6/26
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] F = {0,1,1,2,3,5,8,13,21,34,55,89};
        int[] a = new int[]{0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        int n = 10;
        int key = 62;
        int search = search(a, n, key);
        System.out.println(search);
    }

    /**
     * 折半查找
     *
     * @param a   数组
     * @param n   要查找的数组长度
     * @param key 要查找的关键字
     * @return 位置
     */
    public static int search(int[] a, int n, int key) {

        return 0;
    }
}
