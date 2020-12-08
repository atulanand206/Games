package com.games.LeetCode.Problems.SingleNumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.merge(i, 1, Integer::sum);
        for (Map.Entry<Integer, Integer> integerEntry : map.entrySet())
            if (integerEntry.getValue() == 1)
                return integerEntry.getKey();
        return 0;
    }
}
