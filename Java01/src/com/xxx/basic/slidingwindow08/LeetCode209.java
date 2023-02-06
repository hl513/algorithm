package com.xxx.basic.slidingwindow08;

/**
 * @author HeP
 * @date 2023/1/30 18:04
 */
public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, N = nums.length, res = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
