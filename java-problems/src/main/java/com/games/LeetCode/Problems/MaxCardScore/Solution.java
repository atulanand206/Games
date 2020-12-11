package com.games.LeetCode.Problems.MaxCardScore;

public class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int windowStart = cardPoints.length - k;
        int windowEnd = cardPoints.length - 1;
        System.out.println(cardPoints.length + " : " + windowStart + " : " + windowEnd + " : " + k);
        int windowSum = 0;
        for (int i = windowStart; i <= windowEnd; i++) {
            windowSum += cardPoints[i];
        }
        System.out.println(windowStart + " : " + windowEnd + " : " + windowSum);
        int max = windowSum;
        for (int i = 1; i <= k; i++) {
            windowSum -= cardPoints[windowStart];
            windowEnd = (windowEnd + 1) % cardPoints.length;
            windowStart = (windowStart + 1) % cardPoints.length;
            windowSum += cardPoints[windowEnd];
            System.out.println(windowStart + " : " + windowEnd + " : " + windowSum);
            max = Math.max(windowSum, max);
        }
        System.out.println(max);
        return max;
    }
}