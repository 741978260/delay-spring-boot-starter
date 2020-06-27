package com.mumu.algorithms.searching;

/**
 * @Description 插值查找
 * 折半查找：mid = (low + high)/2 = low + (high-low)/2 ;
 * 插值查找：mid = low + (high-low)*(key - a[low])/(a[high]-a[low]);
 * 从时间复杂度来看，它也是O(logn),但对于表比较大，而关键字分布又比较均匀的查找表来说，
 * 插值查找算法的平均性能比折半性能要好的多。反之，数组中如果分布类似{0,1,2,2000,2001,999998,999999}这种
 * 极端不均匀的数据，用插值查找未必是很合适的选择。
 * @Author Created by Mumu
 * @Date on 2020/6/26
 */
public class InterpolationSearch {
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
//            mid = low + (high-low)/2; // 折半
            mid = low + (high-low)*(key - a[low])/(a[high]-a[low]); // 插值
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
