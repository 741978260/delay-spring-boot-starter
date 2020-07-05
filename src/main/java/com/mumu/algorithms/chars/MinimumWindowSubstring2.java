package com.mumu.algorithms.chars;

/**
 * @Description 最小覆盖子串 （滑动窗口解法 sliding-window）
 * @Author Created by Mumu
 * @Date on 2020/7/5
 */
public class MinimumWindowSubstring2 {
    public static void main(String[] args) {
        //        String S = "ADOBECODEBANC", T = "ABC";
        String S = "addbcafdga4bdjadbc", T = "dabd";
        MinimumWindowSubstring2 obj = new MinimumWindowSubstring2();
        String result = obj.minWindow(S, T);
        System.out.println(result);
    }

    private String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // ascii('z') =122
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部包含多少 T 中的字符，对应字符频数超过不重复计算
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        //[left,right)
        while (right < sLen) {
            if (tFreq[charArrayS[right]] == 0) {
                right++;
                continue;
            }

            if (winFreq[charArrayS[right]] < tFreq[charArrayS[right]]) {
                distance++;
            }
            winFreq[charArrayS[right]]++;
            right++;

            while (distance == tLen) {
            }


        }
        return null;
    }
}
