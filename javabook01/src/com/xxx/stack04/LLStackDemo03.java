package com.xxx.stack04;

/**
 * @author HeP
 * @date 2023/2/9 10:37
 * 基于实现的栈
 */
public class LLStackDemo03 {

    public static void main(String[] args) {
        LLStack stack = new LLStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i * 10);
        }
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }
}
