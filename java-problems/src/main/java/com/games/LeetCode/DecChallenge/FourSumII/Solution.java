package com.games.LeetCode.DecChallenge.FourSumII;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution to LeetCode Problem #454. 4Sum II.
 * <p>
 * The four arrays are reduced to two maps with the maps containing
 * the count of sum of elements of two arrays taken as a pair.
 * If the second map contains the exact value but with negative sign, then that is a tuple.
 * Such counts are calculated as the product of the corresponding counts present in both the maps.
 *
 * @author Atul Anand
 * @version 1.0 - 17th Dec 2020
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> aPlusB = combinedMap(A, B);
        Map<Integer, Integer> cPlusD = combinedMap(C, D);
        for (Map.Entry<Integer, Integer> entry : aPlusB.entrySet()) {
            int key = entry.getKey();
            if (cPlusD.containsKey(-1 * key))
                count += aPlusB.get(key) * cPlusD.get(-1 * key);
        }
        return count;
    }

    private Map<Integer, Integer> combinedMap(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ai : A)
            for (int bi : B)
                map.merge(ai + bi, 1, Integer::sum);
        return map;
    }
}
