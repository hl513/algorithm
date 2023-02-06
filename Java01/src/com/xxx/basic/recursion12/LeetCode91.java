package com.xxx.basic.recursion12;

/**
 * @author HeP
 * @date 2023/2/3 11:07
 */
public class LeetCode91 {

    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        return helper(s, 0, memo);
    }

    private int helper(String s, int i, int[] memo) {
        if (i == s.length()) return 1;
        if (memo[i] > 0) return memo[i];
        if (s.charAt(i) == '0') memo[i] = 0;
        else if (validTwoDigit(s, i)) memo[i] = helper(s, i + 1, memo) + helper(s, i + 2, memo);
        else memo[i] = helper(s, i + 1, memo);
        return memo[i];

    }

    private boolean validTwoDigit(String s, int i) {
        return i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'));
    }

}
