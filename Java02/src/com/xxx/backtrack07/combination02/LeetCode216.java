package com.xxx.backtrack07.combination02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/6 19:59
 */
public class LeetCode216 {

        private int k;
        private final List<Integer> path = new ArrayList<>();
        private final List<List<Integer>> ans = new ArrayList<>();

        // 解法1，枚举下一个数选哪个
        public List<List<Integer>> combinationSum3(int k, int n) {
            this.k = k;
            dfs(9, n);
            return ans;
        }

        private void dfs(int i, int t) {
            int d = k - path.size(); // 还要选 d 个数
            if (t < 0 || t > (i * 2 - d + 1) * d / 2) // 剪枝
                return;
            if (d == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j >= d; --j) {
                path.add(j);
                dfs(j - 1, t - j);
                path.remove(path.size() - 1);
            }
        }


        // 解法2
    public List<List<Integer>> combinationSum302(int k, int n) {
        this.k = k;
        dfs02(9, n);
        return ans;
    }

    private void dfs02(int i, int t) {
        int d = k - path.size(); // 还要选 d 个数
        if (t < 0 || t > (i * 2 - d + 1) * d / 2) // 剪枝
            return;
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选 i
        if (i > d) dfs02(i - 1, t);
        // 选 i
        path.add(i);
        dfs02(i - 1, t - i);
        path.remove(path.size() - 1);
    }



}
