package com.mumu.algorithms.chars;

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

}
