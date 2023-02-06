package com.xxx.basic.presum10;

/**
 * @author HeP
 * @date 2023/1/31 9:55
 */
public class LeetCode370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += value;
            if (end < length - 1) res[end + 1] -= value;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }

}
