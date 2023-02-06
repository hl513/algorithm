package com.xxx.backtrack07.combination02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/6 19:56
 */
public class LeetCode77 {
    // 解法1
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


    // 解法2和解法3的共用部分
    private int k;
    private final List<Integer> path = new ArrayList<>();
    private final List<List<Integer>> ans = new ArrayList<>();


    // 解法2  枚举下一个数选哪个
    public List<List<Integer>> combine02(int n, int k) {
        this.k = k;
        dfs02(n);
        return ans;
    }

    private void dfs02(int i) {
        int d = k - path.size(); // 还要选 d 个数
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; --j) {
            path.add(j);
            dfs02(j - 1);
            path.remove(path.size() - 1);
        }
    }


    // 解法3 选或不选
    public List<List<Integer>> combine03(int n, int k) {
        this.k = k;
        dfs03(n);
        return ans;
    }

    private void dfs03(int i) {
        int d = k - path.size(); // 还要选 d 个数
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选 i
        if (i > d) dfs03(i - 1);
        // 选 i
        path.add(i);
        dfs03(i - 1);
        path.remove(path.size() - 1);
    }




}
