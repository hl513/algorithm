package com.xxx.basic.line01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/28 11:26
 */
public class LeetCode986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);
            if (low <= high) res.add(new int[]{low, high});
            if (A[i][1] < B[j][1]) i++;
            else j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
