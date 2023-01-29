package com.xxx.basic.stack06;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/29 20:34
 */
public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) stack.pop(); // 维护栈
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());  // 将结果存入array中
            stack.push(nums2[i]);  // 当前元素入栈
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
