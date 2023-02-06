package com.xxx.binary02;

import java.util.Arrays;

/**
 * @author HeP
 * @date 2023/2/6 18:01
 */
public class LeetCode33 {

    public int search(int[] nums, int target) {
        int left = -1, right = nums.length; // 开区间 (-1, n)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (isBlue(nums, target, mid)) right = mid; // 蓝色
            else left = mid; // 红色
        }
        return right < nums.length && nums[right] == target ? right : -1;
    }

    private boolean isBlue(int[] nums, int target, int i) {
        int end = nums[nums.length - 1];
        if (nums[i] > end)
            return target > end && nums[i] >= target;
        else
            return target > end || nums[i] >= target;
    }

}
