package com.games.LeetCode.Problems.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final char SPACE = ' ';

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        Map<Character, Integer> tMap = getCharIntMap(t);
        if (s.length() == t.length() && !isMapValid(getCharIntMap(s), tMap))
            return "";
        int start = 0, end = 1;
        int lastValidStart = 0, lastValidEnd = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray())
            map.put(ch, 0);
        map.put(SPACE, 0);
        putToMap(map, t, s.charAt(0));
        int minLength = s.length();
        while (start != s.length() && end != s.length()) {
            while (!isMapValid(map, tMap) && end != s.length()) {
                System.out.printf("%d, %d\n", start, end);
                putToMap(map, t, s.charAt(end++));
            }
            while (isMapValid(map, tMap) && start != s.length()) {
                int length = lengthOfStringInMap(map);
                System.out.printf("%d, %d, %d\n", start, end, length);
                if (length <= minLength) {
                    minLength = length;
                    lastValidStart = start;
                    lastValidEnd = end;
                }
                removeFromMap(map, t, s.charAt(start++));
            }
        }
        System.out.println(lastValidStart);
        System.out.println(lastValidEnd);
        System.out.println(minLength);
        String substring = s.substring(lastValidStart, lastValidEnd);
        if (!isMapValid(getCharIntMap(substring), tMap))
            return "";
        return substring;
    }

    public Map<Character, Integer> getCharIntMap(String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray())
            tMap.merge(ch, 1, Integer::sum);
        return tMap;
    }

    private void putToMap(Map<Character, Integer> map, String t, char s) {
        if (t.contains(String.valueOf(s)))
            map.merge(s, 1, Integer::sum);
        else
            map.merge(SPACE, 1, Integer::sum);
    }

    private void removeFromMap(Map<Character, Integer> map, String t, char s) {
        if (t.contains(String.valueOf(s)))
            map.merge(s, -1, Integer::sum);
        else
            map.merge(SPACE, -1, Integer::sum);
    }

    public boolean isMapValid(Map<Character, Integer> map, Map<Character, Integer> tMap) {
        int itemsPresent = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            if (tMap.containsKey(entry.getKey()))
                if (entry.getValue() < tMap.get(entry.getKey()))
                    return false;
                else
                    itemsPresent++;
        return itemsPresent == tMap.entrySet().size();
    }

    private int lengthOfStringInMap(Map<Character, Integer> map) {
        int length = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            length += entry.getValue();
        return length;
    }
}
