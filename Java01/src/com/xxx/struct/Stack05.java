package com.xxx.struct;

import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/27 11:54
 * 力扣 155
 */
public class Stack05 {
    public static void main(String[] args) {

    }
}

class MinStack {
    // 普通的栈
    Stack<Integer> stack = new Stack<>();
    // 存放最小元素的栈
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);  // 入栈
        // 判断最小栈是否为空，且要入栈的元素是否小于最小栈的栈顶元素，如果小的话，就将该元素存入最小栈
        if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
    }

    public void pop() {
        // 取出栈顶元素
        int top = stack.pop();
        // 如果栈顶元素等于最小栈的栈定元素，则取出
        if (top == minStack.peek()) minStack.pop();
    }

    // 返回栈顶元素
    public int top() {
        return stack.peek();
    }
    // 获得最小值
    public int getMin() {
        return minStack.peek();
    }
}
