package com.xxx.pointer01;

/**
 * @author HeP
 * @date 2023/2/6 16:45
 * 同向双指针  时间复杂度 O(n)
 */
public class LeetCode209 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, ans = n + 1, s = 0, left = 0;
        for (int right = 0; right < n; right++) {
            s += nums[right];
            // 判断子数组的和 移动左端点
            while (s >= target) {
                // +1的原因是 左右指针指向同一个时，就为一个
                ans = Math.min(ans, right - left + 1);
                s -= nums[left++];
            }
        }
        return ans <= n ? ans : 0;
    }

}