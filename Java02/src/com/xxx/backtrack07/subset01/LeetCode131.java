package com.xxx.backtrack07.subset01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/6 19:55
 */
public class LeetCode131 {

    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> path = new ArrayList<>();
    private String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0, 0);
        return ans;
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }

    // start 表示当前这段回文子串的开始位置
    private void dfs(int i, int start) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path)); // 固定答案
            return;
        }

        // 不选 i 和 i+1 之间的逗号（i=n-1 时右边没有逗号）
        if (i < s.length() - 1)
            dfs(i + 1, start);

        // 选 i 和 i+1 之间的逗号
        if (isPalindrome(start, i)) {
            path.add(s.substring(start, i + 1));
            dfs(i + 1, i + 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }
}
