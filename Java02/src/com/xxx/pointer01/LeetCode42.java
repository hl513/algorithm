package com.xxx.pointer01;

import java.util.Stack;

/**
 * @author HeP
 * @date 2023/2/6 17:30
 * 相向双指针
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


    // 前后缀分离
    public int trap03(int[] height) {
        int n = height.length;
        int[] preMax = new int[n], sufMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; ++i)
            preMax[i] = Math.max(preMax[i - 1], height[i]);

        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i)
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);

        int ans = 0;
        for (int i = 0; i < n; ++i)
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        return ans;
    }

    // 相向双指针
    public int trap04(int[] height) {
        int ans = 0, left = 0, right = height.length - 1, preMax = 0, sufMax = 0;
        while (left <= right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            ans += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
        }
        return ans;
    }


}
