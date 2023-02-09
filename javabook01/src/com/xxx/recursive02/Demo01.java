package com.xxx.recursive02;

/**
 * @author HeP
 * @date 2023/2/7 9:08
 * 求n!
 */
public class Demo01 {

    public static void main(String[] args) {
        int fact = Fact(5);
        System.out.println(fact);


        int print = Print(5);
        System.out.println(print);
    }

    // 计算一个正整数的阶乘
    public static int Fact(int n) {
        // 基本情形：当参数为0或1时，直接返回1
        if (n == 1) return 1;
        else if (n == 0) return 1;
        // 递归情形  返回 n*(n-1)!
        else return n * Fact(n - 1);
    }

    // 递归的可视化操作，可以看到每次返回的数据
    public static int Print(int n){
        if (n==0) return 0;
        else{
            System.out.println(n);
            return Print(n-1);
        }
    }
}
