package com.xxx.basic.greedy13;

/**
 * @author HeP
 * @date 2023/2/3 16:55
 */
public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTank = 0, startIndex = 0, N = gas.length, balance = 0;
        for (int i = 0; i < N; i++) {
            balance += gas[i] - cost[i];
            gasTank += gas[i] - cost[i];
            if (gasTank < 0) {
                startIndex = i + 1;
                gasTank = 0;
            }
        }
        return balance < 0 ? -1 : startIndex;
    }
}
