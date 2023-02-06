package com.xxx.basic.slidingwindow08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author HeP
 * @date 2023/1/30 17:23
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!set.add(c)) set.remove(s.charAt(left++));
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring02(String s) {
        int N = s.length();
        int left = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) left = Math.max(map.get(c), left);
            map.put(c, i + 1);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
