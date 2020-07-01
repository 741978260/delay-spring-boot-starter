package com.mumu.algorithms.topk;

import java.util.*;

/**
 * @Description 前K个高频单词
 * @Author Created by Mumu
 * @Date on 2020/7/2
 */
public class TopK {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        // 方法一：排序
        // 计算每个单词的频率，并使用这些频率的自定义排序关系对单词进行排序。然后取前K
        List<String> topk = sort(words, k);
        System.out.println(topk);
    }

    public static List<String> sort(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>(16);
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) ->
                count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2) : count.get(w2) - count.get(w1)
        );
        return candidates.subList(0, k);
    }

}
