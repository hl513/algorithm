package com.xxx.basic.stack06;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/29 20:59
 */
public class LeetCode1019 {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) nums.add(cur.val);
        int n = nums.size();
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums.get(i) >= stack.peek()) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(nums.get(i));
        }
        return res;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
