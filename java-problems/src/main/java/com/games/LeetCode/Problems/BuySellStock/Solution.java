package com.games.LeetCode.Problems.BuySellStock;

public class Solution {

    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxDiff = 0;
        for (int price : prices) {
            if (price < minSoFar) {
                minSoFar = price;
            }
            int diff = price - minSoFar;
            if (diff > 0)
                maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }
}
