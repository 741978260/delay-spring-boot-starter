package com.mumu.algorithms.chars;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description 连续重复字符串个数最多
 * @Author Created by Mumu
 * @Date on 2021/1/6
 */
public class RepeatContinuouslyString {
    public static void main(String[] args) {
        String[] str = new String[]{"a", "a", "b", "b", "b", "c", "c", "c", "c", "d", "d", "c", "c"};
        test(str);
    }

    public static void test(String[] str) {
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;

        // 左指针
        while (left < str.length) {
            int count = 0;
            while (str[left].equals(str[right])) {
                //记录个数
                count++;
                //
                right++;

            }
            left = right;
            int num = map.getOrDefault(str[left], 0);
            if (count > num) {
                map.put(str[left], count);
            }

        }
        // 排序
        String a = "";
        int b = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > b) {
                b = entry.getValue();
                a = entry.getKey();
            }
        }
        System.out.println(a + " " + b);

    }
}
