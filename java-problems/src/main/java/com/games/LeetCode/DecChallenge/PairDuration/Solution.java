package com.games.LeetCode.DecChallenge.PairDuration;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int t : time) {
            if (map.containsKey(((60 - t % 60)) % 60)) {
                count += map.get((60 - t % 60) % 60);
            }
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return count;
    }

    private void printArrayWithIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%d : %d \n", i, arr[i]);
        System.out.println();
    }
}
