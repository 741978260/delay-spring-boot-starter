package com.mumu.algorithms.searching;

/**
 * @Description 折半查找，又称为二分查找。它的前提是线性表中的记录必须是关键码有序，
 * 线性表必须采用顺序存储。
 * 我们可以将这个数组的查找过程绘制成一颗二叉树，“具有n个结点的完全二叉树的深度为log以2为底n的对数+1”
 * 最终折半算法的时间复杂度为O(logn),它显然远远好于顺序查找的O(n)
 * @Author Created by Mumu
 * @Date on 2020/6/26
 */
public class BinarySearch {
    public static void main(String[] args) {
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
        int low, high, mid;
        low = 1; // 定义最低下标为记录首位
        high = n; // 定义最高下标为记录首位
        while (low <= high) {
            mid = (low + high) / 2; // 折半
            if (key < a[mid]) { //若查找值 比中值 小
                high = mid - 1; // 最高下标调整到中位下标小一位
            } else if (key > a[mid]) { //若查找值 比中值 大
                low = mid + 1; // 最低下标调整到中位下标大一位
            } else {
                return mid;  //若相等则说明mid即为查找到的位置
            }
        }
        return 0;
    }
}
