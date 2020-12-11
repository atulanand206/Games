package com.games.LeetCode.Problems.GrumpyBookstoreOwner;

public class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int windowLength) {
        int windowSum = getWindowSum(customers, grumpy, windowLength);
        int remainingSum = getRemainingSum(customers, grumpy, windowLength);
        int max = windowSum + remainingSum;
        for (int index = 0; index < grumpy.length - windowLength; index++) {
            windowSum = alterWindowSumAtIndex(customers, windowSum, windowLength, index);
            remainingSum = alterRemainingSum(customers, grumpy, remainingSum, windowLength, index);
            max = Math.max(max, windowSum + remainingSum);
        }
        return max;
    }

    private int alterRemainingSum(int[] customers, int[] grumpy, int remainingSum, int windowLength, int index) {
        return remainingSum
                + getSatisfactionAtIndex(customers, grumpy, index)
                - getSatisfactionAtIndex(customers, grumpy, index + windowLength);
    }

    private int alterWindowSumAtIndex(int[] customers, int windowSum, int windowLength, int index) {
        return windowSum - customers[index] + customers[index + windowLength];
    }

    private int getRemainingSum(int[] customers, int[] grumpy, int windowLength) {
        int remainingSum = 0;
        for (int index = windowLength; index < grumpy.length; index++)
            remainingSum += getSatisfactionAtIndex(customers, grumpy, index);
        return remainingSum;
    }

    private int getWindowSum(int[] customers, int[] grumpy, int windowLength) {
        int windowSum = 0;
        for (int index = 0; index < windowLength && index < grumpy.length; index++)
            windowSum += customers[index];
        return windowSum;
    }

    private int getSatisfactionAtIndex(int[] customers, int[] grumpy, int index) {
        return customers[index] * (1 - grumpy[index]);
    }
}
