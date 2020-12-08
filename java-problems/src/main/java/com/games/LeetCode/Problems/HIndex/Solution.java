package com.games.LeetCode.Problems.HIndex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;
        if (citations.length == 1)
            return Math.min(citations[0], 1);
        List<Integer> list = Arrays.stream(citations).boxed().sorted().collect(Collectors.toList());
        Collections.reverse(list);
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            if (list.get(i) >= i && list.get(i + 1) <= i) {
                return i + 1;
            }
        }
        return citations.length;
    }
}
