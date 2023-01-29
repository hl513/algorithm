package com.xxx.basic.dfs03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/29 9:30
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
}
