package com.games.LeetCode.Problems.FirstMissingPositive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        List<Integer> ints = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int max = 1;
        for (int i : nums)
            if (i>0 && i > max)
                max = i;
        int min = Integer.MAX_VALUE;
        for (int i : nums)
            if (i>0 && i < min)
                min = i;
        return min;
    }
}
