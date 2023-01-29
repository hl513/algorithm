package com.xxx.basic.divde05;

/**
 * @author HeP
 * @date 2023/1/29 19:47
 *
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        divide(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    private void divide(int[] nums, int left, int right, int k) {
        if (left >= right) return;
        int position = conquer(nums, left, right);
        if (position == nums.length - k) return;
        else if (position < nums.length - k) divide(nums, position + 1, right, k);
        else divide(nums, left, position - 1, k);
    }

    private int conquer(int[] nums, int left, int right) {
        int pivot = nums[right], wall = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, right);
        return wall;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
