package com.games.LeetCode.Problems.MaxProductSubarray;

import com.games.chess.utils.ListUtils;

public class Solution {

    private int[][] dp;

    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int startIndex = 0;
        int endIndex = 1;
        int windowProduct = nums[0] * nums[1];
        int maxProduct = 1;

        while (startIndex != nums.length - 2 && endIndex != nums.length - 1) {
            if (windowProduct > maxProduct) {
                maxProduct = windowProduct;
            }
            while (nums[endIndex + 1] > 1)
                endIndex++;
            if (nums[startIndex] != 0) {
                windowProduct /= nums[startIndex];
            } else {
                windowProduct = product(nums, startIndex + 1, endIndex);
            }
            windowProduct *= nums[endIndex + 1];
            startIndex++;
        }

        return maxProduct;
    }

    private int product(int[] nums, int startIndex, int endIndex) {
        int product = 1;
        for (int i = startIndex; i < endIndex; i++)
            product *= nums[i];
        return product;
    }

    private void init(int length) {
        dp = new int[length + 1][length + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp.length; j++)
                dp[i][j] = 1;
    }
}
