package com.xxx.basic.line01;

import java.util.Arrays;

/**
 * @author HeP
 * @date 2023/1/28 11:10
 * 无重叠空间
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠
 */
public class LeetCode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0, end = Integer.MIN_VALUE;
        for (int[] cur : intervals) {
            if (end <= cur[0]) end = cur[1];
            else count++;
        }
        return count;
    }
}
