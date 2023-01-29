package com.xxx.basic.dfs03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/29 9:12
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

}
