package com.xxx.backtrack07.subset01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/6 19:53
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {  // 先用当前的
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i + 1);   // 再传下一步
            tmp.remove(tmp.size() - 1);
        }
    }


    // 解法2 解法3 共用
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;


    // 解法2
    public List<List<Integer>> subsets02(int[] nums) {
        this.nums = nums;
        dfs02(0);
        return ans;
    }

    private void dfs02(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path)); // 固定答案
            return;
        }
        // 不选 nums[i]
        dfs02(i + 1);
        // 选 nums[i]
        path.add(nums[i]);
        dfs02(i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }

    // 解法3
    public List<List<Integer>> subsets03(int[] nums) {
        this.nums = nums;
        dfs03(0);
        return ans;
    }

    private void dfs03(int i) {
        ans.add(new ArrayList<>(path)); // 固定答案
        if (i == nums.length) return;
        for (int j = i; j < nums.length; ++j) { // 枚举选择的数字
            path.add(nums[j]);
            dfs03(j + 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }



}
