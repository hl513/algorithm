package com.xxx.basic.presum10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeP
 * @date 2023/1/31 8:38
 */
public class LeetCode560 {

    // preSum - preSum = target 要找的是map里面是否存在 preSum - target
    public int subarraySum(int[] nums, int target) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // 放的是 prefix sum和 frequency(频率)
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - target)) res += map.get(sum - target);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public int subarraySum02(int[] nums, int k) {
        int cnt = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
