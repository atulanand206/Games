package com.games.LeetCode.Problems.ContainerWithMostWater;

public class Solution {

    public int maxArea(int[] height) {
        if (height.length==0 || height.length==1)
            return 0;
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++)
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[j], height[i]);
                if (area > maxArea)
                    maxArea = area;
            }
        return maxArea;
    }
}
