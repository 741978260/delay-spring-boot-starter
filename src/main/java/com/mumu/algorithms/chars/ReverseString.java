package com.mumu.algorithms.chars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 反转字符串
 * @Author Created by Mumu
 * @Date on 2020/7/2
 */
public class ReverseString {

    public static void main(String[] args) {
        String str = "hellost4";
        char[] s = str.toCharArray();
        reverse(s);
        System.out.println(s);

        List<String> collect = Stream.of("i", "love", "a", "b").collect(Collectors.toList());
        Object[] o = collect.toArray();
        reverseRange(o, 0, 4);
        System.out.println(Arrays.asList(o));
    }

    public static void reverse(char[] s) {
        // 左右双指针
        int left = 0;
        int right = s.length - 1;
        // 交互元素的临时变量 temp
        char temp;
        while (left < right) {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }

    }

    private static void reverseRange(Object[] a, int lo, int hi) {
        hi--;
        while (lo < hi) {
            Object t = a[lo];
            a[lo++] = a[hi];
            a[hi--] = t;
        }
    }

}
