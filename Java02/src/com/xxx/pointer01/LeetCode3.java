package com.xxx.pointer01;


/**
 * @author HeP
 * @date 2023/2/6 17:11
 * 同向双指针  时间复杂度 O(n)
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray();
        int n = s.length, ans = 0, left = 0;
        int[] cnt = new int[128];
        for (int right = 0; right < n; right++) {
            char c = s[right];
            ++cnt[c];
            while (cnt[c] > 1) --cnt[s[left++]];
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
