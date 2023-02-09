package com.xxx.stack04;

import java.util.Stack;

/**
 * @author HeP
 * @date 2023/2/9 10:46
 */
@SuppressWarnings("all")
public class Example01 {

    public static void main(String[] args) {
        String str = "abaXaba";
        System.out.println(isPalindrome(str));

        String str02 = "aXba";
        System.out.println(isPalindrom02(str02));

        // 删除数组中相邻的重复元素
        int[] nums = {1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5};
        int [] arr ={1,9,6,8,8,8,0,1,1,0,6,5};
        int index = removeAdjacentDuplicates(nums);
        for (int i = 0; i <= index; i++) {
            System.out.print(" " + nums[i]);
        }

        System.out.println();
        int index2  =removeAdjacentDuplicates(arr);
        for (int i = 0; i <=index2 ; i++) {
            System.out.print(" "+arr[i]);
        }

    }

    /**
     * 给定一个有多个a字符和b字符组成的字符数组，求该字符串是否是回文串
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        char[] A = str.toCharArray();
        int i = 0, j = A.length - 1;
        while (i < j && A[i] == A[j]) {
            i++;
            j--;
        }
        if (i < j) return false;
        else return true;
    }

    /**
     * 用栈来进行判断是否是回文串
     * 1、遍历链表直至遇到字符 X
     * 在遍历过程中将经过的每个字符 入栈
     * 对于链表的后一半，把每个元素与栈顶元素比较。如果相等，执行一次出战操作
     * 并且移动到下一个元素继续比较
     * 如果比较时出现不相等，那么输入的字符串不是回文串
     * 继续这个过程，直至栈空或者字符串不是回文
     *
     * @param str
     * @return
     */
    public static boolean isPalindrom02(String str) {
        char ch[] = str.toCharArray();
        Stack<Character> stack = new Stack();
        int i = 0;
        // 将X之前的字符都入栈
        while (ch[i] != 'X') {
            stack.push(ch[i]);
            i++;
        }
        i++;
        while (i < ch.length) {
            if (stack.isEmpty()) return false;
            // 将栈顶元素与后面的元素进行比较
            if (ch[i] != (Character) stack.pop().charValue()) return false;
            i++;
        }
        return true;
    }

    /**
     * 给定一个栈，如何只使用栈操作，逆置栈中的内容
     * 1、首先，将栈中所有元素递归出栈，直至栈空
     * 2、每次递归向上步骤时，将上一步中出栈的元素插入栈底
     *
     * @param stack
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int tmp = stack.pop();
        reverseStack(stack);
        // 将递归出现的元素，插入栈底
        insertAtBottom(stack, tmp);
    }

    private static void insertAtBottom(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        int tmp = stack.pop();
        insertAtBottom(stack, val);
        stack.push(tmp);
    }

    /**
     * 设计一个可以把栈中元素按照升序排列的排序算法，并且算法不能对栈的具体实现方式有限定
     *
     * @param stack
     * @return
     */
    public static Stack sort(Stack<Integer> stack) {
        LLStack r = new LLStack();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!r.isEmpty() && r.top() > tmp) stack.push(r.pop());
            r.push(tmp);
        }
        return r;
    }

    /**
     * 删除所有相邻的重复元素；
     * 给定一个数字数组，删除相邻的重复元素，结果数组中不能有任何相邻的重复数字
     * 用到就地栈：当栈中元素与当前数字不相等时，将当前数字入栈。如果当前数字与栈顶元素相等，跳过该数字
     * 直到找到与栈顶元素不相等的数字，并从栈中删除该元素
     *
     * @param nums
     * @return
     */
    public static int removeAdjacentDuplicates(int[] nums) {
        int stkptr = -1;
        int i = 0;
        while (i < nums.length) {
            if (stkptr == -1 || nums[stkptr] != nums[i]) {
                stkptr++;
                // 将不重复的元素放入栈中
                nums[stkptr] = nums[i];
                i++;
            } else {
                // 直接跳过
                while (i < nums.length && nums[stkptr] == nums[i]) i++;
                stkptr--;
            }
        }
        return stkptr;
    }

}
