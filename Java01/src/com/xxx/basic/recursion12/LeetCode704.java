package com.xxx.basic.recursion12;

/**
 * @author HeP
 * @date 2023/2/3 10:10
 */
public class LeetCode704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = start + (end - start >> 1);
        if (target == nums[mid]) return mid;
        else if (target < nums[mid]) return binarySearch(nums, start, mid - 1, target);
        else return binarySearch(nums, mid + 1, end, target);
    }

}
