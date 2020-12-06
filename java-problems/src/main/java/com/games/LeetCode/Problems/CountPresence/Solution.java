package com.games.LeetCode.Problems.CountPresence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> commonChars(String[] A) {
        List<List<Integer>> maps = new ArrayList<>();
        for (String aa : A) {
            List<Integer> alphas = new ArrayList<>();
            for (int i = 0; i < 26; i++)
                alphas.add(0);
            for (char b : aa.toCharArray()) {
                int indx = (int) b - 97;
                alphas.set(indx, alphas.get(indx) + 1);
            }
            maps.add(alphas);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (List<Integer> map : maps) {
                min = Math.min(min, map.get(i));
            }
            for (int k = 0; k < min; k++)
                result.add(String.valueOf((char) (i + 97)));
        }
        return result;
    }
}
