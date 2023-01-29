package com.xxx.basic.binary04;

/**
 * @author HeP
 * @date 2023/1/29 14:53
 */
public class LeetCode4 {


    public double findMedianSortedArrays(int[] numsX, int[] numsY) {
        if (numsX.length > numsY.length) return findMedianSortedArrays(numsY, numsX); // 1比2长度小
        int left = 0, right = numsX.length;
        while (left <= right) {
            int x = left + (right - left >> 1); // 求中间值
            int y = (numsX.length + numsY.length + 1) / 2 - x;
            int xLeft = (x == 0) ? Integer.MIN_VALUE : numsX[x - 1];
            int xRight = (x == numsX.length) ? Integer.MAX_VALUE : numsX[x];
            int yLeft = (y == 0) ? Integer.MIN_VALUE : numsY[y - 1];
            int yRight = (y == numsY.length) ? Integer.MAX_VALUE : numsY[y];
            if (xLeft <= yRight && yLeft <= xRight) {
                if ((numsX.length + numsY.length) % 2 == 0) return ((double) Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2;
                else return (double) Math.max(xLeft, yLeft);
            }
            else if (xRight > yLeft) right = x - 1;
            else left = x + 1;
        }
        return -1;
    }


}

