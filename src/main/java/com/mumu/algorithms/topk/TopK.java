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
        // 方法二：堆
        // 计算每个单词的频率，然后将其添加到存储到大小为k的小根堆中。它将频率最小的候选项放在堆的顶部。
        // 最后，我们从堆中弹出最多 k 次，并反转结果，就可以得到前 k 个高频单词。
        List<String> list = topKFrequent(words, k);
        System.out.println(list);
    }

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>(16);
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : count.get(w1) - count.get(w2));
        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
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
