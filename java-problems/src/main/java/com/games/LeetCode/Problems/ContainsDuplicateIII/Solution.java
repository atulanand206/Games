package com.games.LeetCode.Problems.ContainsDuplicateIII;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
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
