package com.xxx.basic.recursion12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/3 10:24
 */
public class LeetCode22 {
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

}
