package com.xxx.basic.line01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author HeP
 * @date 2023/1/28 11:31
 * 天际线问题 困难
 */
public class LeetCode218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int preMax = 0;
        for (int[] h : height) {
            if (h[1] < 0) pq.offer(-h[1]);
            else pq.remove(h[1]);
            int curMax = pq.peek();
            if (curMax != preMax) {
                res.add(List.of(h[0], curMax));
                preMax = curMax;
            }
        }
        return res;
    }

}
