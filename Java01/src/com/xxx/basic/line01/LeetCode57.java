package com.xxx.basic.line01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/28 10:50
 * 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）
 */
public class LeetCode57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] cur : intervals) {
            if (newInterval == null || cur[1] < newInterval[0]) res.add(cur);
                // 时间太早，还没到插入点
            else if (cur[0] > newInterval[1]) {
                res.addAll(List.of(newInterval, cur));  // 时间过去了，最后一个插入
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

}
