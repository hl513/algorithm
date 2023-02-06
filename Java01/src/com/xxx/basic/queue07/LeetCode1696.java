package com.xxx.basic.queue07;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author HeP
 * @date 2023/1/30 16:51
 */
public class LeetCode1696 {

    public int maxResult(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(0);
        for (int i = 0; i < N - 1; i++) {
            while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();
            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) q.pollLast();
            q.offerLast(i);
            dp[i + 1] = dp[q.peekFirst()] + nums[i + 1];
        }
        return dp[N - 1];
    }

    public int maxResult02(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{nums[0], 0});
        for (int i = 1; i < n; i++) {
            while (i - pq.peek()[1] > k) pq.remove();
            score[i] = nums[i] + score[pq.peek()[1]];
            pq.add(new int[]{score[i], i});
        }
        return score[n - 1];
    }
}
