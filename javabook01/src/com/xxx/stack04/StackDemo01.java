package com.xxx.stack04;

/**
 * @author HeP
 * @date 2023/2/9 10:18
 */
public class StackDemo01 {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        // 入栈
        for (int i = 0; i < 10; i++) {
            stack.push(i*10);
        }
        // 出栈
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
