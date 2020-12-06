package com.games.LeetCode.DecChallenge.CanPlaceFlowers;

public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int allowed = 0;
        for (int i = 0; i < flowerbed.length - 2; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                allowed++;
                i++;
            }
        }
        return allowed >= n;
    }
}
