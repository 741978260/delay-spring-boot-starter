package com.mumu.algorithms.searching;

/**
 * @Description 顺序查找，又叫线性查找
 * 缺点：每次循环时，都需要对i是否越界，即是否小于等于n作判断。事实上，还是一种更好一点的办法，就是设置一个哨兵，见SequentialSearch2类demo
 * @Author Created by Mumu
 * @Date on 2020/6/25
 */
public class SequentialSearch {
    public static void main(String[] args) {
        int[] a = new int[]{0,5,7,2,8,9,4,1};
        int n = 5;
        int key = 2;
        int search = search(a, n, key);
        System.out.println(search);
    }

    /**
     * 顺序查找，a为数组，n为要查找的数组长度，key为要查找的关键字
     *
     * @param a   数组
     * @param n   要查找的数组长度
     * @param key 要查找的关键字
     * @return 位置
     */
    public static int search(int[] a, int n, int key) {
        int i;
        for (i = 1; i <= n; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return 0;
    }
}
