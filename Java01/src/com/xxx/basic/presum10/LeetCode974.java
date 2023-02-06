package com.xxx.basic.presum10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeP
 * @date 2023/1/31 9:03
 */
public class LeetCode974 {

    /**
     * 核心思路：当相同余数再次出现的时候，两次出现余数i,j之间的subarray一定是能够被整除的
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefix = 0, res = 0;
        for (int num : nums) {
            prefix = (prefix + num % k + k) % k;  // 为了避免 num为负数的情况
            res += count.getOrDefault(prefix, 0);
            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }
}
