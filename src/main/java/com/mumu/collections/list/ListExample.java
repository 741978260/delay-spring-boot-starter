package com.mumu.collections.list;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/3
 */
public class ListExample {
    public static void main(String[] args) {
        List<String> collect = Stream.of("i", "love", "a", "you", "ai").collect(Collectors.toList());
//        Collections.sort(collect);
        Collections.sort(collect, new ComparatorImpl());
        System.out.println(collect);
    }

    static class ComparatorImpl implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
