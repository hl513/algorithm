package com.xxx.basic.slidingwindow08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeP
 * @date 2023/1/30 17:49
 */
public class LeetCode395 {

    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int unique = 1; unique <= 26; unique++) {
            Map<Character, Integer> map = new HashMap<>();
            int left = 0, validCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == k) validCnt++;  // 第k次出现合格数量
                while (map.keySet().size() > unique) {
                    char leftChar = s.charAt(left);
                    if (map.getOrDefault(leftChar, 0) == k) validCnt--;
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    if (map.get(leftChar) == 0) map.remove(leftChar);
                    left++;
                }
                int cnt = map.keySet().size();
                if (cnt == unique && cnt == validCnt) res = Math.max(i - left + 1, res);
            }
        }
        return res;
    }
}
