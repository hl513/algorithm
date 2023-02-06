package com.xxx.basic.twopointer11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/31 10:20
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;

                } else if (nums[start] + nums[end] + nums[i] < 0) start++;
                else end--;
            }
        }
        return res;
    }

}
