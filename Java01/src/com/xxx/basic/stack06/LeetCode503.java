package com.xxx.basic.stack06;

import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/29 20:49
 */
public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, res[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) stack.pop();
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);

        }
        return res;
    }

}
