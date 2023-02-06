package com.xxx.basic.presum10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeP
 * @date 2023/1/31 9:15
 */
public class LeetCode525 {


    // tle
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        for (int start = 0; start < nums.length; start++) {
            int zeroes = 0, ones = 0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) zeroes++;
                else ones++;
                if (zeroes == ones) maxLen = Math.max(maxLen, end - start + 1);
            }
        }
        return maxLen;
    }

    public int findMaxLength02(int[] nums) {
        for (int i = 0; i < nums.length; i++) if (nums[i] == 0) nums[i] = -1;
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) res = Math.max(res, i - map.get(sum));
            else map.put(sum, i);
        }
        return res;
    }
}
