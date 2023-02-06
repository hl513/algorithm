package com.xxx.basic.twopointer11;

/**
 * @author HeP
 * @date 2023/1/31 10:20
 */
public class LeetCode680 {

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        // 左右指针
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i >= j) return true;  // 遍历结束 直接是一个回文串
        // 左指针往右走一步，或者 右指针往左走一步
        if (isPalin(s, i + 1, j) || isPalin(s, i, j - 1)) return true;
        return false;
    }

    private boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

}
