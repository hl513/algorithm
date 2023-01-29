package com.xxx.basic.stack06;

import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/29 21:05
 */
public class LeetCode739 {

    // stack里面储存的是index，需要算距离
    public int[] dailyTemperatures(int[] tmp) {
        int n = tmp.length, res[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && tmp[i] >= tmp[stack.peek()]) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
