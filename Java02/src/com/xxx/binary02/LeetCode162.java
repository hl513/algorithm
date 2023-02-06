package com.xxx.binary02;

/**
 * @author HeP
 * @date 2023/2/6 17:54
 */
public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        int l = -1, r = nums.length - 1;  // 开区间 (-1,n-1)
        while (l + 1 < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid;
        }
        return r;
    }

}
