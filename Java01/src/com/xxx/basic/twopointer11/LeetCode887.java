package com.xxx.basic.twopointer11;

/**
 * @author HeP
 * @date 2023/1/31 11:01
 */
public class LeetCode887 {

    public int superEggDrop(int k, int N) {
        int[][] memo = new int[k + 1][N + 1];
        return helper(k, N, memo);
    }

    private int helper(int k, int n, int[][] memo) {
        if (n <= 1) return n;
        if (k == 1) return n;
        if (memo[k][n] > 0) return memo[k][n];
        int min = n;
        for (int i = 1; i <= n; i++) {
            int left = helper(k - 1, i - 1, memo);
            int right = helper(k, n - i, memo);
            min = Math.min(min, Math.max(left, right) + 1);
        }
        memo[k][n] = min;
        return min;
    }

}
