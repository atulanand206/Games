package com.games.dP.ZigZagSubSequence;

import com.games.chess.utils.ListUtils;

import static java.lang.Math.max;

public class Solution {

    int zigzag(int[] nums) {
        int size = nums.length;
        if (size < 2)
            return size;
        int[][] dp = new int[size][2];
        for (int i = 0; i < size; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i][0] = max(dp[j][1] + 1, dp[i][0]);
                else if (nums[i] < nums[j])
                    dp[i][1] = max(dp[j][0] + 1, dp[i][1]);
            }
        }
        return max(dp[size - 1][0], dp[size - 1][1]);
    }
}
