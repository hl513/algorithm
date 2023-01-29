package com.xxx.basic.divde05;

import java.util.Arrays;

/**
 * @author HeP
 * @date 2023/1/29 15:36
 */
public class LeetCode169 {
    // 分治法
    public int majorityElement(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        int leftRes = divide(nums, left, mid);
        int rightRes = divide(nums, mid + 1, right);
        if (leftRes == rightRes) return leftRes;
        int leftCnt = conquer(nums, leftRes, left, right);
        int rightCnt = conquer(nums, rightRes, left, right);
        return leftCnt > rightCnt ? leftRes : rightRes;
    }

    private int conquer(int[] nums, int target, int left, int right) {
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) cnt++;
        }
        return cnt;
    }

    // 投票法
    public int majorityElement02(int[] nums) {
        int cnt = 0, res = 0;
        for (int num : nums) {
            if (cnt == 0) res = num;
            cnt += (num == res) ? 1 : -1;
        }
        return res;
    }

    // sort法
    public int majorityElement03(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


}
