package com.xxx.binary02;

/**
 * @author HeP
 * @date 2023/2/6 18:06
 */
public class LeetCode153 {

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = -1, right = n - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[n - 1]) right = mid; // 蓝色
            else left = mid; // 红色
        }
        return nums[right];
    }

}
