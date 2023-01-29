package com.xxx.basic.stack06;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/29 20:23
 * 单调栈：先进后出
 * 栈中元素，按递增顺序或递减顺序排序的时候
 * 优势：时间复杂度是线性的，每个元素遍历一次
 */
public class MonotonicStack {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        // 第一个2后面比2大的数是4，1后面比1大的数是2，第二个2后面比2大的数是4，4后面没有比4大的数，填-1，3后面没有比3大的数，填-1
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }

    /**
     * 三步走：
     * 1、维持递增栈
     * 2、放入最后结果array
     * 3、当前元素入栈
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) stack.pop();  // 递增栈 与栈顶元素比较，比栈顶元素小,pop出来
            // 从栈顶拿出元素
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            // 当前元素入栈
            stack.push(nums[i]);
        }
        return res;
    }

}
