package com.xxx.queue05;

/**
 * @author HeP
 * @date 2023/2/9 17:46
 * 用两个队列实现栈
 */
public class StackWithTwoQueues {
    LLQueue queue1;
    LLQueue queue2;

    public StackWithTwoQueues() {
        queue1 = new LLQueue();
        queue2 = new LLQueue();
    }

    /**
     * 入栈算法：在任何一个非空队列中插入元素
     * 检查队列Q1是否为空。如果Q1为空，那么对Q2执行入队操作
     * 否则对Q1执行入队操作
     * @param data
     */
    public void push(int data) {
        if (queue1.isEmpty()) queue2.enQueue(data);
        else queue1.enQueue(data);
    }

    /**
     * 出栈算法：将n-1个元素移动到另一个队列中，删除当前队列中的最后一个元素来完成出栈操作
     * 1、如果队列Q1为空，那么返回从Q1移n-1个元素到Q2中，然后对Q1中的最后一个元素执行出队操作并返回该元素
     * 2、如果队列Q2为非空，那么从Q2移n-1个元素到Q1中，然后对Q2中的最后一个元素执行出队操作并返回该元素
     * @return
     */
    public int pop() {
        int i, size;
        if (queue2.isEmpty()) {
            size = queue1.getQueueSize();
            i = 0;
            while (i < size - 1) {
                queue2.enQueue(queue1.deQueue());
                i++;
            }
            return queue1.deQueue();
        } else {
            size = queue2.getQueueSize();
            i=0;
            while (i < size - 1) {
                queue1.enQueue(queue2.deQueue());
                i++;
            }
            return queue2.deQueue();
        }
    }


}
