package com.xxx.backtrack07.arrangement03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/6 20:02
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums) {
        // list需要创建一个新的
        if (list.size() == nums.length) res.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                // 去重，一个数字只能使用一次
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                dfs(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }


    private int[] nums;
    private List<Integer> path;
    private boolean[] onPath;
    private final List<List<Integer>> ans = new ArrayList<>();

    // 解法2
    public List<List<Integer>> permute02(int[] nums) {
        this.nums = nums;
        path = Arrays.asList(new Integer[nums.length]);
        onPath = new boolean[nums.length];
        dfs02(0);
        return ans;
    }

    private void dfs02(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; ++j) {
            if (!onPath[j]) {
                path.set(i, nums[j]);
                onPath[j] = true;
                dfs02(i + 1);
                onPath[j] = false; // 恢复现场
            }
        }
    }



}
