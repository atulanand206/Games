package com.games.LeetCode.Problems.RemoveDuplicates;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int numbers = 1, lastNumber = nums[0];
        for (int i : nums) {
            if (i != lastNumber) {
                lastNumber = i;
                nums[numbers++] = lastNumber;
            }
        }
        return numbers;
    }
}
