package com.games.LeetCode.WeeklyContest218.MaxKSumPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.merge(i, 1, Integer::sum);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        int maxOperations = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (key < k && map.containsKey(k - key)) {
                if (2 * key == k) {
                    int integer = map.get(key);
                    int opsAvailable = integer / 2;
                    System.out.println(key + "--" + opsAvailable);
                    maxOperations += opsAvailable;
                    map.put(key, integer - opsAvailable * 2);
                } else {
                    int integer = map.get(k - key);
                    System.out.println(val + " " + integer);
                    int min = Math.min(val, integer);
                    maxOperations += min;
                    map.put(k - key, integer - min);
                    map.put(key, val - min);
                }
            }
        }
        return maxOperations;
    }
}
