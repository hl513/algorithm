package com.xxx.basic.queue07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HeP
 * @date 2023/1/30 10:50
 */
public class LeetCode1425 {

    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] sum = new int[nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
            if (!deque.isEmpty()) sum[i] += sum[deque.peekFirst()];
            res = Math.max(res, sum[i]);
            if (!deque.isEmpty() && i - deque.peek() >= k) deque.pollFirst();
            while (!deque.isEmpty() && sum[deque.peekLast()] <= sum[i]) deque.pollLast();
            if (sum[i] > 0) deque.offerLast(i);
        }
        return res;
    }
}
