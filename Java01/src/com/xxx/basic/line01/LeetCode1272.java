package com.xxx.basic.line01;

import java.util.*;

/**
 * @author HeP
 * @date 2023/1/28 11:04|
 * 删除区间
 */
public class LeetCode1272 {

    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] i : intervals) {
            if (i[1] <= toBeRemoved[0] || i[0] >= toBeRemoved[1]) {
                res.add(Arrays.asList(i[0], i[1]));
            } else {
                if (i[0] < toBeRemoved[0])
                    res.add(Arrays.asList(i[0], toBeRemoved[0]));
                if (i[1] > toBeRemoved[1])
                    res.add(Arrays.asList(toBeRemoved[1], i[1]));
            }
        }
        return res;
    }

}