package com.xxx.basic.dfs03;

/**
 * @author HeP
 * @date 2023/1/29 9:52
 */
public class LeetCode37 {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++)
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    return false;
                }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int row = 0; row < 9; row++)
            if (board[row][j] == c) return false;
        for (int col = 0; col < 9; col++)
            if (board[i][col] == c) return false;
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if (board[row][col] == c) return false;
        return true;
    }

}
