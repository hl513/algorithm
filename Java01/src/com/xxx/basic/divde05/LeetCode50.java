package com.xxx.basic.divde05;

/**
 * @author HeP
 * @date 2023/1/29 19:43
 */
public class LeetCode50 {

    public double myPow(double x, int n) {
        // 当为0或1时，直接返回本身
        if (x == 0 || x == 1) return x;
        if (n < 0) return 1 / pow(x, -n);
        return pow(x, n);
    }

    private double pow(double x, int n) {
        // 任何的数的0次方都为1
        if (n == 0) return 1;
        double y = pow(x, n / 2);
        if (n % 2 == 0) return y * y;
        else return y * y * x;
    }

}
