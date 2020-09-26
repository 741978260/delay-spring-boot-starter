package com.mumu.algorithms.searching;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/9/21
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        int n = 10;
        int key = 62;
        int search = search2(a, n, key);
        System.out.println(search);
    }

    public static int search2(int[] a, int n, int key) {
        int mid, high, low;
        low = 1;
        high = n;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}
