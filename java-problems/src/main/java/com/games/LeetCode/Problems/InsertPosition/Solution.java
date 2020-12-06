package com.games.LeetCode.Problems.InsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int indx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                indx = i;
                break;
            }
        }
        if (nums[nums.length -1] < target)
            indx = nums.length;
        return indx;
    }
}
