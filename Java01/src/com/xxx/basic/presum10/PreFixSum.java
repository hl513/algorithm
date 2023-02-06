package com.xxx.basic.presum10;

/**
 * @author HeP
 * @date 2023/1/31 8:31
 * 前缀和
 * 出现 子数组和  或者 连续的子数组
 */
public class PreFixSum {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 2, 1, 6};
    }

    // 模板1 size = N,首位为 nums[0]
    public void preFixSum01(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    // 模板1 size = N+1,prefix = 0
    public void preFixSum02(int[] nums) {
        int N = nums.length;
        int[] sum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

}
