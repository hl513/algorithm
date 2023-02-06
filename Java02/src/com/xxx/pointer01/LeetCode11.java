package com.xxx.pointer01;

/**
 * @author HeP
 * @date 2023/2/6 17:26
 * 相向双指针
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        int res = 0, left = 0, right = height.length - 1;
        while (left < right) {
            // 面积 底边的宽度 * 两个高度的最小值
            int minHeight = Math.min(height[left], height[right]);  // 最小高度
            int width = right - left;  // 底边的宽度
            res = Math.max(res, minHeight * width);
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return res;
    }
}
