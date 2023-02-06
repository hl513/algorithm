package com.xxx.basic.slidingwindow08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeP
 * @date 2023/1/30 17:39
 */
public class LeetCode340 {

    public int lengthOfLongestSubstringDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            // getOrDefault()  如果存在key, 则返回其对应的value, 否则返回给定的默认值
            map.put(cur, map.getOrDefault(cur, 0) + 1);  // 1、进：当前遍历的i进入窗口
            while (map.size() > k) {     // 2、出：当窗口不符合条件时left持续退出窗口
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
                left++;
            }
            res = Math.max(res, i - left + 1);  // 3、算：现在窗口 valid(有效的) ，我们计算结果
        }
        return res;
    }
}
