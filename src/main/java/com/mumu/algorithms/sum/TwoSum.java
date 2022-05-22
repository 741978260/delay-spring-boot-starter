package com.mumu.algorithms.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 两数之和
 * @Author Created by Mumu
 * @Date on 2020/7/8
 */
public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 18;
        int result0[] = test(nums, target);
        System.out.println(Arrays.toString(result0));
        int result00[] = test2(nums, target);
        System.out.println(Arrays.toString(result00));
        int result[] = twoSum1(nums, target);
        System.out.println(Arrays.toString(result));
        int result2[] = twoSum2(nums, target);
        System.out.println(Arrays.toString(result2));
    }

    private static int[] test2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            // 差值
            int val = target - nums[i];
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    private static int[] test(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }




    /**
     * 暴力解法 时间复杂度O(n2)
     *
     * @param nums   数组
     * @param target 求和
     * @return 结果
     */
    private static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
