package com.xxx.basic.twopointer11;

/**
 * @author HeP
 * @date 2023/1/31 10:31
 */
public class LeetCode408 {

    public static void main(String[] args) {
        boolean b = validWordAbbreviation("apple", "a2e");
        System.out.println(b);
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') return false;
            int start = j;
            while (i < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }

}
