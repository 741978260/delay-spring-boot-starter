package com.mumu.algorithms.sum;

/**
 * @Description 爬楼梯
 * 爬楼梯：
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 这是一个斐波那契数列，即a[n] = a[n-2] + a[n-1]
 * @Author Created by Mumu
 * @Date on 2020/12/28
 */
public class ClimbTheStairs {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 递归
//        int result = fib01(10);
        // 动态规划法 (利用数组来存储)
//        int result = fib04(10);
        // 状态压缩法(又称滚动数组、滑动窗口，用于优化动态规划法的空间复杂度)
        int result = fib05(10);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 结果：" + result);
    }

    private static int fib05(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        n = n - 1;
        int result = 0;
        int zero = 1;
        int first = 1;
        while (n > 0) {
            result = zero + first;
            zero = first;
            first = result;
            n--;
        }
        return result;
    }

    private static int fib04(int n) {
        if (n == 0) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static int fib01(int n) {
        int total;
        if (n == 1 || n == 2) {
            total = n;
        } else {
            total = fib01(n - 2) + fib01(n - 1);
        }
        return total;
    }
}
