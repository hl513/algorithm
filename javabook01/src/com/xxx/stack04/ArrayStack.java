package com.xxx.stack04;

/**
 * @author HeP
 * @date 2023/2/9 10:13
 * 基于数组实现的栈  静态栈，空间有局限性
 */
public class ArrayStack {
    private int top; // 栈针
    private int capacity;
    private int[] array;

    public ArrayStack() {
        capacity = 20;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return (top == capacity - 1);
    }

    public void push(int val) {
        if (isStackFull()) System.out.println("Stack OverFlow");
        else array[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        } else return array[top--];
    }

    public void deleteStack() {
        top = -1;
    }
}
