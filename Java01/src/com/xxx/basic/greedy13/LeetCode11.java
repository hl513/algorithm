package com.xxx.basic.greedy13;

/**
 * @author HeP
 * @date 2023/2/3 16:53
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        int res = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            res = Math.max(res, minHeight * width);
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return res;
    }
}
