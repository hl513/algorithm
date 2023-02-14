package com.xxx.queue05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/2/9 17:24
 */
public class Example01 {

    public static void main(String[] args) {
        DynArrayQueue q = new DynArrayQueue();
        for (int i = 0; i < 10; i++) {
            q.enQueue(i * 10);
        }
        // 逆置队列元素
        reverseQueue(q);
        int size = q.getQueueSize();
        for (int i = 0; i < size; i++) {
            System.out.println(q.deQueue());
        }

        // 给定一个整数栈，如何检查栈中每对相邻数字是否是连续的。
        Stack<Integer> stack = new Stack<>();
        int[] nums = {4, 5, -2, -3, 11, 10, 5, 6, 20};
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }
        System.out.println(checkStackPairwise(stack));


        //  给定一个整数队列，如何把两个队列前半部分和后半部分的元素相互交叉，完成队列中元素的重新排列。
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        interLeavingQueue(queue);

        int len = queue.size();
        for (int i = 0; i < len; i++) {
            System.out.print(queue.poll() + " ");
        }

        // 求前k个数的逆置
        System.out.println();
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            q1.add(i * 10);
        }
        reverseQueueFirstKelements(4, q1);
        int length = q1.size();
        for (int i = 0; i < length; i++) {
            System.out.print(q1.poll() + " ");
        }



    }

    /**
     * 逆置队列元素的算法。
     * 要求在访问队列元素时，只能使用队列抽象数据类型中的操作
     *
     * @param queue
     * @return
     */
    public static DynArrayQueue reverseQueue(DynArrayQueue queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) stack.push(queue.deQueue());
        while (!stack.isEmpty()) queue.enQueue(stack.pop());
        return queue;
    }

    /**
     * 给定一个整数栈，如何检查栈中每对相邻数字是否是连续的。
     * 每对数字的值可以是递增或递减的，如果栈中元素的个数是奇数，那么组对时忽略栈顶元素
     *
     * @param stack
     * @return
     */
    public static boolean checkStackPairwise(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();
        boolean pairwiseOrdered = true;
        while (!stack.isEmpty()) queue.add(stack.pop());
        while (!queue.isEmpty()) stack.push(queue.remove());
        while (!stack.isEmpty()) {
            int n = stack.pop();
            queue.add(n);
            if (!stack.isEmpty()) {
                int m = stack.pop();
                queue.add(m);
                if (Math.abs(n - m) != 1) pairwiseOrdered = false;
            }
        }
        while (!queue.isEmpty()) stack.push(queue.remove());
        return pairwiseOrdered;
    }

    /**
     * 给定一个整数队列，如何把两个队列前半部分和后半部分的元素相互交叉，完成队列中元素的重新排列。
     *
     * @param queue
     */
    public static void interLeavingQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) throw new IllegalArgumentException();
        Stack<Integer> stack = new Stack<>();
        int halfSize = queue.size() / 2;
        for (int i = 0; i < halfSize; i++) stack.push(queue.poll());
        while (!stack.isEmpty()) queue.add(stack.pop());
        for (int i = 0; i < halfSize; i++) queue.add(queue.poll());
        for (int i = 0; i < halfSize; i++) stack.push(queue.poll());
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
            queue.add(queue.poll());
        }
    }

    /**
     * 给定一个整数k和一个整数队列，如何把队列中前k个元素逆置，其余元素次序保持不变
     *
     * @param k
     * @param queue
     */
    public static void reverseQueueFirstKelements(int k, Queue<Integer> queue) {
        if (queue == null || k > queue.size()) throw new IllegalArgumentException();
        else if (k > 0) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < k; i++) stack.push(queue.remove());
            while (!stack.isEmpty()) queue.add(stack.pop());
            // 逆置剩余元素
            for (int i = 0; i < queue.size() - k; i++) queue.add(queue.remove());
        }
    }


}
