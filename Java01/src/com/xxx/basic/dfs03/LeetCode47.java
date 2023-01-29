package com.xxx.basic.dfs03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/29 9:37
 */
public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backrack(List<List<Integer>> list, List<Integer> level, int[] nums, boolean[] used) {
        if (level.size() == nums.length) list.add(new ArrayList<>(level));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                level.add(nums[i]);
                backrack(list, level, nums, used);
                used[i] = false;
                level.remove(level.size() - 1);
            }
        }
    }

}
