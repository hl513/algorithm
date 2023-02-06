package com.xxx.backtrack07.combination02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/6 20:01
 */
public class LeetCode22 {

    // 解法1
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
        return res;

    }
    private void dfs(int left, int right, String level, List<String> res) {
        if (left == 0 && right == 0) res.add(level);
        if (left > 0) dfs(left - 1, right, level + "(", res);
        if (right > left) dfs(left, right - 1, level + ")", res);
    }


    private int n;
    private char[] path;
    private final List<String> ans = new ArrayList<>();

    // 枚举选左括号还是右括号
    public List<String> generateParenthesis02(int n) {
        this.n = n;
        path = new char[n * 2];
        dfs02(0, 0);
        return ans;
    }

    private void dfs02(int i, int open) {
        if (i == n * 2) {
            ans.add(new String(path));
            return;
        }
        if (open < n) { // 可以填左括号
            path[i] = '(';
            dfs02(i + 1, open + 1);
        }
        if (i - open < open) { // 可以填右括号
            path[i] = ')';
            dfs02(i + 1, open);
        }
    }

}
