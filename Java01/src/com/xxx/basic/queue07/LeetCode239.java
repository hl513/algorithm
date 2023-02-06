package com.xxx.basic.queue07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HeP
 * @date 2023/1/30 10:25
 */
public class LeetCode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[N - k + 1];
        for (int i = 0; i < N; i++) {
            int startWindowIndex = i - k + 1;
            while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();  // 左出q,保证窗口大小 k-1
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast(); // 右出q,保证递减队列
            q.offerLast(i);  // 进q，此时 q.size == k
            if (startWindowIndex >= 0) res[startWindowIndex] = nums[q.peekFirst()];  // 使用q左边最大值
        }
        return res;
    }
}
