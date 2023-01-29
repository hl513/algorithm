package com.xxx.basic.stack06;

import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/29 21:34
 */
public class LeetCode42 {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, N = height.length;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pre = stack.pop();
                if (stack.isEmpty()) break;
                int minHeight = Math.min(height[stack.peek()], height[i]);
                res += (minHeight - height[pre]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }

    // dp
    public int trap02(int[] height) {
        if (height.length == 0) return 0;
        int res = 0, N = height.length;
        int[] left = new int[N], right = new int[N];
        left[0] = height[0];
        right[N - 1] = height[N - 1];
        for (int i = 1; i < N; i++) left[i] = Math.max(left[i - 1], height[i]);
        for (int i = N - 2; i >= 0; i--) right[i] = Math.max(right[i + 1], height[i]);
        for (int i = 0; i < N; i++) res += Math.min(left[i], right[i]) - height[i];
        return res;
    }

}
