package com.xxx.basic.queue07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HeP
 * @date 2023/1/30 16:44
 */
public class LeetCode1438 {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>(), mind = new ArrayDeque<>();
        int left = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!maxd.isEmpty() && maxd.peekLast() < nums[i]) maxd.pollLast();
            while (!mind.isEmpty() && nums[i] < mind.peekLast()) mind.pollLast();
            maxd.add(nums[i]);
            mind.add(nums[i]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[left]) maxd.poll();
                if (mind.peek() == nums[left]) mind.poll();
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }


}
