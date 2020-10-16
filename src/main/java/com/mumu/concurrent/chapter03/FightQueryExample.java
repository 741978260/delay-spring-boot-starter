package com.mumu.concurrent.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/10/16
 */
public class FightQueryExample {

    //合作的各大航空公司
    private static List<String> fightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        long base = System.currentTimeMillis();
        List<String> results = search("SH", "BJ");

        System.out.println("================result===============");
        results.forEach(System.out::println);
        System.out.println("耗时：" + (System.currentTimeMillis() - base) / 10);
    }

    private static List<String> search(String original, String dest) {
        final List<String> result = new ArrayList<>();

        //
        List<FightQueryTask> tasks = fightCompany.stream().map(f -> createSearchTask(f, original, dest)).collect(Collectors.toList());

        // 分别启动这几个线程
        tasks.forEach(Thread::start);

        // 分别调用每一个线程的join方法，阻塞当前线程
        tasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 在此之前，当前线程会阻塞，获取每一个查询线程的结果，并且加入到result中
        tasks.stream().map(FightQuery::get).forEach(result::addAll);

        return result;
    }

    private static FightQueryTask createSearchTask(String f, String original, String dest) {
        return new FightQueryTask(f, original, dest);
    }
}
