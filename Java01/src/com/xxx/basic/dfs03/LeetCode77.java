package com.xxx.basic.dfs03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/29 9:47
 */
public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> level, int n, int k, int index) {
        if (level.size() == k) res.add(new ArrayList<>(level));
        else {
            for (int i = index; i <= n; i++) {
                level.add(i);
                dfs(res, level, n, k, i + 1);
                level.remove(level.size() - 1);

            }
        }
    }


}
