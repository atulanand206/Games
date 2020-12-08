package com.games.LeetCode.Problems.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            if (map.get(ch) == null) {
                Set<Integer> set = new HashSet<>();

            }
        }
        return t;
    }
}
