package com.xxx.basic.line01;

import java.util.Arrays;

/**
 * @author HeP
 * @date 2023/1/28 11:18
 * 删除被覆盖区间
 */
public class LeetCode1288 {

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int cnt = 0, cur = 0;
        for (int[] a : intervals) {
            if (cur < a[1]) {
                cur = a[1];
                cnt++;
            }
        }
        return cnt;
    }

}
