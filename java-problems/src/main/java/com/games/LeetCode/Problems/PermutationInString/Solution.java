package com.games.LeetCode.Problems.PermutationInString;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int startIndex = 0;
        int windowLength = s1.length() - 1;
        Map<Character, Integer> sMap = getCharIntMap(s1);
        Map<Character, Integer> map = getCharIntMapRange(s2, startIndex, windowLength);
        for (int i = startIndex + 1; i < s2.length() - windowLength; i++) {
            if (isMapValid(map, sMap))
                return true;
            char key = s2.charAt(i - 1);
            decrementOrRemoveKey(map, key);
            map.merge(s2.charAt(i + windowLength), 1, Integer::sum);
        }
        return false;
    }

    private Map<Character, Integer> getCharIntMapRange(String s2, int startIndex, int endIndex) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = startIndex; i <= endIndex && i < s2.length(); i++)
            map.merge(s2.charAt(i), 1, Integer::sum);
        return map;
    }

    private Map<Character, Integer> getCharIntMap(String s1) {
        Map<Character, Integer> sMap = new TreeMap<>();
        for (char ch : s1.toCharArray())
            sMap.merge(ch, 1, Integer::sum);
        return sMap;
    }

    private void decrementOrRemoveKey(Map<Character, Integer> map, char key) {
        Integer integer = map.get(key);
        if (integer == null || integer <= 1)
            map.remove(key);
        else
            map.merge(key, -1, Integer::sum);
    }

    private boolean isMapValid(Map<Character, Integer> map, Map<Character, Integer> smap) {
        return map.entrySet().equals(smap.entrySet());
    }
}
