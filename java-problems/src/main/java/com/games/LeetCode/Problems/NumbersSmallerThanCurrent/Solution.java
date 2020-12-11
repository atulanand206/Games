package com.games.LeetCode.Problems.NumbersSmallerThanCurrent;

import java.util.Arrays;

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 0);
        for (int i1 = 0; i1 < nums.length; i1++) {
            int i = nums[i1];
            int less = 0;
            for (int j : nums) {
                if (j < i)
                    less++;
            }
            result[i1] = less;
        }
        return result;
    }
}
