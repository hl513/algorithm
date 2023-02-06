package com.xxx.basic.presum10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeP
 * @date 2023/1/31 8:41
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 求出两数之差等于 target
            int diff = target - nums[i]; // 将val拿出来 去map里面找索引，存在则放入map中
            if (map.containsKey(diff)) return new int[]{map.get(diff), i};
            // 将key和value放入集合中
            map.put(nums[i], i);
        }
        return null;
    }
}
