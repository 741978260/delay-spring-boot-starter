package com.mumu.algorithms.searching;

/**
 * @Description
 * 这种在查找方向的尽头设置“哨兵”免去了在查找过程中每一次比较后都要判断
 * 查找位置是否越界的小技巧，看似与SequentialSearch差别不大，但在总数据
 * 比较多时，效率提高很大，是非常好的编码技巧
 * 对应顺序查找算法来说，查找成功最好的情况就是在第一个位置就找到了，算法
 * 时间复杂度为O(1),最坏的情况就是在最后一个位置才找到，需要n次比较，
 * 时间复杂度为O(n),当查找不成功时，需要n+1次比较，时间复杂度为O(n)。
 * 所以，平均查找次数为（n+1）/2,所以最终时间复杂度还是O(n)
 * @Author Created by Mumu
 * @Date on 2020/6/25
 */
public class SequentialSearch2 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 5, 7, 2, 8, 9, 4, 1};
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
        a[0] = key; /*设置a[0]为关键字值，我们称之为“哨兵”*/
        i = n; /*循环从数组尾部开始*/
        while (a[i] != key) {
            i--;
        }
        return i;
    }
}
