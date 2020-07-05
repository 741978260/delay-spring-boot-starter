package com.mumu.algorithms.chars;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description 最小覆盖子串 （滑动窗口解法 sliding-window）
 * @Author Created by Mumu
 * @Date on 2020/7/5
 */
public class MinimumWindowSubstring {

    Map<Character, Integer> ori = new HashMap<>(16);
    Map<Character, Integer> cnt = new HashMap<>(16);

    public static void main(String[] args) {
//        String S = "ADOBECODEBANC", T = "ABC";
        String S = "addbcafdga4bdjadbc", T = "dabd";
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String result = obj.slidingWindow(S, T);
        System.out.println(result);

    }

    private String slidingWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (cnt.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
