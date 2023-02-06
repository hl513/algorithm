package com.xxx.basic.queue07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HeP
 * @date 2023/1/30 10:36
 */
public class LeetCode862 {

    /**
     * 求出前缀和之后，需求：j>i && preSum[j]-preSum[i] >= k && (j-i)最小
     * 相当于排队，对某个人来说，要找到前面比我矮最少K的人，且和我这个人的距离最近
     *
     * @param A
     * @param k
     * @return
     */
    public int shortestSubarray(int[] A, int k) {
        int N = A.length, res = N + 1;
        long[] sum = new long[N + 1];
        // 求前缀和
        for (int i = 0; i <= N; i++) sum[i + 1] = sum[i] + A[i];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!q.isEmpty() && sum[i] - sum[q.peekFirst()] >= k) res = Math.min(res, i - q.pollFirst());
            while (!q.isEmpty() && sum[q.peekLast()] >= sum[i]) q.pollLast();
            q.offerLast(i);
        }
        return res <= N ? res : -1;
    }

}
