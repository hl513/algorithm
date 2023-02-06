package com.xxx.basic.presum10;

/**
 * @author HeP
 * @date 2023/1/31 10:04
 */
public class LeetCode304 {

}

class NumMatrix {
    int[][] sums;

    public  NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        sums = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] + matrix[i][j] - sums[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}



