package com.games.LeetCode.Problems.ContainsDuplicate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.merge(i, 1, Integer::sum);
        return !map.values()
                .stream()
                .filter(k -> k>1)
                .collect(Collectors.toSet())
                .isEmpty();
    }
}
