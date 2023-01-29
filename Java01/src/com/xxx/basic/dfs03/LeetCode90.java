package com.xxx.basic.dfs03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/29 9:21
 */
public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> level, int[] nums, int index) {
        res.add(new ArrayList<>(level));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue; // 保证相同元素只按顺序添加一次
            level.add(nums[i]);
            helper(res, level, nums, i + 1);
            level.remove(level.size() - 1);
        }
    }
}
