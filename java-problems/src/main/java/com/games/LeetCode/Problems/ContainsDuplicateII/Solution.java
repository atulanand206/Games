package com.games.LeetCode.Problems.ContainsDuplicateII;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = map.getOrDefault(nums[i], new TreeSet<>());
            set.add(i);
            map.put(nums[i], set);
        }
        List<Map.Entry<Integer, Set<Integer>>> list = map.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toList());
        for (Map.Entry<Integer, Set<Integer>> entry : list) {
            if (isValidSet(entry.getValue(), k))
                return true;
        }
        return false;
    }

    private boolean isValidSet(Set<Integer> value, int k) {
        List<Integer> list = new ArrayList<>(value);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) <= k)
                return true;
        }
        return false;
    }
}
