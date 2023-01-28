package com.xxx.basic.line01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/28 10:44
 * 合并区间
 */
public class LeetCode56 {

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return new int[0][];
        // 排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] cur = intervals[0];
        for (int[] next : intervals) {
            // 前一个的结束时间比后一个的开始时间大，则合并起来
            if (cur[1] >= next[0]) cur[1] = Math.max(cur[1], next[1]);
            else {
                // 否则直接跳过
                res.add(cur);
                cur = next;
            }
        }
        res.add(cur);
        return res.toArray(new int[0][]);
    }
}
