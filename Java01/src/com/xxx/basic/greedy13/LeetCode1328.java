package com.xxx.basic.greedy13;

/**
 * @author HeP
 * @date 2023/2/3 16:55
 */
public class LeetCode1328 {

    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }
        s[n - 1] = 'b';
        return n < 2 ? "" : new String(s);
    }

}
