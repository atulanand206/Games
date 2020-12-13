package com.games.LeetCode.Weekly219.CountMatches;

public class Solution {
    public int numberOfMatches(int n) {
        int teamsLeft = n;
        int totalMatches = 0;
        while (teamsLeft > 1) {
            if (teamsLeft % 2 == 0) {
                totalMatches += teamsLeft / 2;
                teamsLeft = teamsLeft / 2;
            } else {
                totalMatches += (teamsLeft - 1) / 2;
                teamsLeft = (teamsLeft - 1) / 2 + 1;
            }
        }
        return totalMatches;
    }
}
