package com.xxx.basic.binary04;

import java.util.Arrays;

/**
 * @author HeP
 * @date 2023/1/29 15:16
 * 1552，1482，1283，1292 同类型的题 未做
 */
public class LeetCode410 {

    public int splitArray(int[] nums, int k) {
        // 求数组和 通过转转成流的形式
        int sum = Arrays.stream(nums).sum();
        // 求最大值 也是通过流的形式
        int max = Arrays.stream(nums).max().getAsInt();
        return binary(nums, k, sum, max);
    }

    private int binary(int[] nums, int m, int high, int low) {
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (valid(nums, m, mid)) high = mid - 1;
            else low = mid + 1;
        }
        return low;

    }

    private boolean valid(int[] nums, int m, int subArraySum) {
        int curSum = 0, cnt = 1;
        for (int num : nums) {
            curSum += num;
            if (curSum > subArraySum) {
                curSum = num;
                cnt++;  // 每次超过了我们裁的数字max，证明我们应该剪掉
                if (cnt > m) return false;
            }
        }
        return true;
    }
}
