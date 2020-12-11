package com.games.LeetCode.DecChallenge.RemoveDuplicates;

import com.games.chess.utils.ListUtils;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        ListUtils.print(nums);
        int numbers = 0, lastNumber = -1, count = 1;
        for (int i : nums) {
            if (i == lastNumber && count < 2) {
                nums[numbers++] = lastNumber;
                count++;
            } else if (i != lastNumber) {
                lastNumber = i;
                nums[numbers++] = lastNumber;
                count = 1;
            }
        }
        ListUtils.print(nums);
        return numbers;
    }
}
