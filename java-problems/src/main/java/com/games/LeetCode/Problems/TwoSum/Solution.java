package com.games.LeetCode.Problems.TwoSum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        List<Integer> ints = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> required = ints.stream().map(c -> target - c).collect(Collectors.toList());
        int a = 0, b = 0;
        for (int i = 0; i < required.size(); i++) {
            Integer x = required.get(i);
            if (ints.contains(x) && i != ints.indexOf(x)) {
                a = ints.indexOf(x);
                b = i;
                break;
            }
        }
        return new int[]{a, b};
    }
}
