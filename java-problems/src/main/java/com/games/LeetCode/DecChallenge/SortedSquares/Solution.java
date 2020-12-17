package com.games.LeetCode.DecChallenge.SortedSquares;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int[] sortedSquares(int[] nums) {
        return getSquaresArray(getCountMap(nums), nums.length);
    }

    private Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : nums)
            map.merge(i * i, 1, Integer::sum);
        return map;
    }

    private int[] getSquaresArray(Map<Integer, Integer> countMap, int length) {
        int[] result = new int[length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int j;
            for (j = i; j < i + entry.getValue(); j++)
                result[j] = entry.getKey();
            i = j;
        }
        return result;
    }
}
