package com.xxx.queue05;

import com.xxx.stack04.LLStack;

import java.util.Stack;

/**
 * @author HeP
 * @date 2023/2/9 17:36
 * 用两个栈实现一个队列
 */
public class QueueWithTwoStacks {

    Stack stack1;
    Stack stack2;

    public QueueWithTwoStacks() {
        stack1 = new LLStack();
        stack2 = new LLStack();
    }

    public boolean isEmpty() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty();
    }

    /**
     * 入队算法
     * 只需要将元素压入栈 stack1
     *
     * @param data
     */
    public void enQueue(Object data) {
        stack1.push(data);
    }

    /**
     * 出队算法
     * 1、如果栈2不为空，那么对 stack2执行出栈操作并返回出栈的元素
     * 2、如果栈2为空，那么把 stack1中的所有元素移动到stack2中，然后弹出stack2栈顶的元素并返回该元素
     * 3、如果栈1也为空，那么抛出错误
     *
     * @return
     */
    public Object deQueue() {
        // 栈2不为空，直接抛出栈2的元素
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            // 栈1不空，栈2为空，将栈1的元素弹出 压入栈2中
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            // 返回栈2的栈顶元素
            return stack2.pop();
        }
    }

}
