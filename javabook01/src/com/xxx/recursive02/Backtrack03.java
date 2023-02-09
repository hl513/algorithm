package com.xxx.recursive02;

import java.util.Arrays;

/**
 * @author HeP
 * @date 2023/2/7 10:06
 * 回溯
 */
public class Backtrack03 {

    static int[] A = new int[3];

    public static void main(String[] args) {
        Binary(3);
//        k_string(5,2);
    }

    // 生成所有n位长的字符串
    // 我们用字符类型的数组A[n]存储二进制字符串，从最后一位开始赋值，直到第一位，每一次赋值都有0 1两种可能。
    public static void Binary(int n) {
        if (n < 1) System.out.println(Arrays.toString(A));
        else {
            A[n - 1] = 0; // 从最后一个开始进行
            Binary(n - 1); // 接着递归
            A[n - 1] = 1;  // 下一个接着
            Binary(n - 1);
        }
    }

    // 生成长度为 n 的所有 k进制串，串中每位的取值为 0..k-1
    public static void k_string(int n, int k) {
        // 处理长度为n的所有k进制串
        if (n < 1) System.out.println(Arrays.toString(A));
        else {
            for (int i = 0; i < k; i++) {
                A[n - 1] = i;
                k_string(n - 1, k);
            }
        }
    }

}
