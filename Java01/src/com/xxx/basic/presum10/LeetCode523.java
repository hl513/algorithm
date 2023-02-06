package com.xxx.basic.presum10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeP
 * @date 2023/1/31 9:10
 */
public class LeetCode523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (map.containsKey(sum)) { // 如果找到之前有存在余数相等的位置，二者一相减就可以余数为0
                if (i - map.get(sum) > 1) return true;
            } else map.put(sum, i);
        }
        return false;
    }
}
