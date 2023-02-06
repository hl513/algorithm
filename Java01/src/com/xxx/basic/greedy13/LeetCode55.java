package com.xxx.basic.greedy13;

/**
 * @author HeP
 * @date 2023/2/3 16:55
 */
public class LeetCode55 {
    Integer[] memo;

    public boolean canJump(int[] nums) {
        memo = new Integer[nums.length];
        memo[memo.length - 1] = 1;
        return canJumpFromPostion(0, nums) == 1;
    }

    private int canJumpFromPostion(int pos, int[] nums) {
        if (memo[pos] != null) return memo[pos];
        int furthest = Math.min(pos + nums[pos], nums.length - 1);
        for (int next = pos + 1; next <= furthest; next++) {
            if (canJumpFromPostion(next, nums) == 1) return memo[pos] = 1;
        }
        return memo[pos] = -1;
    }

    public boolean canJump02(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= max) max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }


}
