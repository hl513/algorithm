package com.xxx.pointer01;

/**
 * @author HeP
 * @date 2023/2/6 17:18
 * 相向双指针
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            // 将第一个数和最后一个数相加，然后与目标值进行比较，看是左指针移动还是右指针移动
            int v = numbers[l] + numbers[r];
            if (v < target) ++l;
            else if (v > target) --r;
            else return new int[]{l + 1, r + 1};
        }
        return new int[]{};
    }
}
