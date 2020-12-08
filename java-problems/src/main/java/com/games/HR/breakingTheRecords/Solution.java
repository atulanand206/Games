package com.games.HR.breakingTheRecords;

public class Solution {

    static int[] breakingRecords(int[] scores) {
        int min = 0, max = 0;
        if (scores.length > 0) {
            int currentMin = scores[0], currentMax = scores[0];
            for (int score : scores) {
                if (score < currentMin) {
                    currentMin = score;
                    min++;
                }
                if (score > currentMax) {
                    currentMax = score;
                    max++;
                }
            }
        }
        return new int[]{max, min};
    }
}
