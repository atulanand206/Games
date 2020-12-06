package com.games.LeetCode.Problems.Isomorphic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        List<Character> charactersInT = new ArrayList<>();
        List<Character> charactersInS = new ArrayList<>();
        List<Integer> indicesInS = new ArrayList<>();
        List<Integer> indicesInT = new ArrayList<>();
        Map<Character, Integer> mapSS = new HashMap<>();
        Map<Character, Integer> maptT = new HashMap<>();
        intermediate(s, indicesInS, mapSS);
        intermediate(t, indicesInT, maptT);
        for (int i=0;i<indicesInS.size();i++)
            if (!indicesInS.get(i).equals(indicesInT.get(i)))
                return false;
        return true;
    }

    private void intermediate(String s, List<Character> charactersInS, List<Integer> sList) {
        for (char c : s.toCharArray()) {
            if (charactersInS.contains(c)) {
                sList.add(charactersInS.indexOf(c));
            } else {
                sList.add(charactersInS.size());
                charactersInS.add(c);
            }
        }
    }

    private void intermediate(String s, List<Integer> sList,  Map<Character, Integer> mapS) {
        for (char c : s.toCharArray()) {
            if (mapS.containsKey(c)) {
                sList.add(mapS.get(c));
            } else {
                int size = mapS.size();
                sList.add(size);
                mapS.put(c, size);
            }
        }
    }
}
