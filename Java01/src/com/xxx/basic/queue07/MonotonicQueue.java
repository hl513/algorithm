package com.xxx.basic.queue07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HeP
 * @date 2023/1/30 10:07
 * 单调队列
 * 承载的基础数据结构是队列，实现是双端队列，队列中存入的元素的是数组索引，队头元素为窗口的最小（最大）元素
 * Deque<Integer> q = new ArrayDeque<>();
 * 队头删除不符合有效窗口的元素，队尾删除不符合最值的候选元素
 * <p>
 * 去尾操作：队尾元素出队列。当队列有新元素待入队，需要从队尾开始，删除影响队列单调性的元素，维护队列的单调性。
 * （删除一个队尾元素后，就重新判断新的队尾元素）
 * 去尾操作结束后，将该新元素入队列
 * 删头操作：队头元素出队列。判断队头元素是否在待求解的区间之内，如果不在，就将其删除。
 * 取解操作：经过上面的两个操作，取出队列的头元素，就是 当前区间的极值
 */
public class MonotonicQueue {

    /**
     * 需保证：
     * 1、插入必须在去尾之后来位置单调性
     * 2、根据不同题目来改变取解的具体位置
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] monotonicaQueue(int[] nums, int k) {
        int N = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[N - k + 1];
        for (int i = 0; i < N; i++) {
            while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();  // 左出 q,保证窗口大小 k-1
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast(); // 右出 q,保证递减队列
            q.offerLast(i); // 进 q ,此时 q.size == k
            q.peekFirst();  // 使用q左边最大值处理结果，可以在不同的位置
        }
        return res;
    }


}
