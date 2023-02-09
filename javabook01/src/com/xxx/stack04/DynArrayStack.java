package com.xxx.stack04;

/**
 * @author HeP
 * @date 2023/2/9 10:21
 * 动态栈
 */
public class DynArrayStack {
    private int top;
    private int capacity;
    private int[] array;

    public DynArrayStack() {
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return top == capacity - 1;
    }

    public void push(int val) {
        if (isStackFull()) doubleStack();
        array[++top] = val;
    }

    // 动态扩容
    private void doubleStack() {
        int newArray[] = new int[capacity * 2];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity = capacity * 2;
        array = newArray;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack OverFlow");
            return -1;
        } else return (array[top--]);
    }

    public void deleteStack() {
        top = -1;
    }

}
