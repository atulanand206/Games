package com.games.LeetCode.Biweekly41.ConsistentStrings;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        Map<Character, Integer> allowedMap = getCharIntMap(allowed);
        int count = 0;
        for (String word : words) {
            boolean extra = false;
            Map<Character, Integer> wordMap = getCharIntMap(word);
            for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
                if (!allowedMap.containsKey(entry.getKey())) {
                    extra = true;
                    break;
                }
            }
            if (!extra)
                count++;
        }
        return count;
    }

    private Map<Character, Integer> getCharIntMap(String s1) {
        Map<Character, Integer> sMap = new TreeMap<>();
        for (char ch : s1.toCharArray())
            sMap.merge(ch, 1, Integer::sum);
        return sMap;
    }
}
