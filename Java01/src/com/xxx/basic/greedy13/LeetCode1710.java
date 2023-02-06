package com.xxx.basic.greedy13;

import java.util.Arrays;

/**
 * @author HeP
 * @date 2023/2/3 16:53
 */
public class LeetCode1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        int i = 0, res = 0;
        while (i < boxTypes.length) {
            while (boxTypes[i][0] > 0 && truckSize > 0) {
                res += boxTypes[i][1];
                boxTypes[i][0]--;
                truckSize--;
            }
            i++;
        }
        return res;
    }

}
