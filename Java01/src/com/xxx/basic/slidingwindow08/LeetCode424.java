package com.xxx.basic.slidingwindow08;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author HeP
 * @date 2023/1/30 18:12
 */
public class LeetCode424 {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        long[] cnt = new long[26];
        int left = 0, res = 0;
        for (int i = 0; i < N; i++) {
            cnt[s.charAt(i) - 'A']++;
            while (i - left + 1 - findMax(cnt) > k) {
                cnt[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    private long findMax(long[] cnt) {
        return Arrays.stream(cnt).max().getAsLong();
    }
}
