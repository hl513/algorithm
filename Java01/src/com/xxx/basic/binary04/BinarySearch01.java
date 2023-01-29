package com.xxx.basic.binary04;

/**
 * @author HeP
 * @date 2023/1/29 14:49
 */
public class BinarySearch01 {

    // 推荐写法
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public int binarySearch02(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid;
            else l = mid + 1;
        }
        return -1;
    }

}
