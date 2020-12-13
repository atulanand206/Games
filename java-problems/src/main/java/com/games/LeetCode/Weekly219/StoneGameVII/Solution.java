package com.games.LeetCode.Weekly219.StoneGameVII;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int stoneGameVII(int[] stones) {
        List<Integer> ints = Arrays.stream(stones).boxed().collect(Collectors.toList());
        int sum = 0;
        for (int in : stones)
            sum += in;
        int aliceScore = 0, bobScore = 0;
        boolean aliceTurn = true;
        while (ints.size() != 0) {
            if (aliceTurn) {
                int minIndex = chooseMinIndex(ints, 0, ints.size() - 1);
                System.out.println(minIndex);
                int min = ints.get(minIndex);
                sum -= min;
                aliceScore += sum;
                ints.remove(minIndex);
            } else {
                int maxIndex = chooseMaxIndex(ints, 0, ints.size() - 1);
                System.out.println(maxIndex);
                int max = ints.get(maxIndex);
                sum -= max;
                bobScore += sum;
                ints.remove(maxIndex);
            }
            aliceTurn = !aliceTurn;
        }
        return aliceScore - bobScore;
    }

    private int chooseMinIndex(List<Integer> ints, int start, int end) {
        if (end >= ints.size())
            return start;
        if (start == end)
            return start;
        if (ints.get(start).equals(ints.get(end)))
            return chooseMinIndex(ints, start + 1, end - 1);
        if (ints.get(start) == Math.min(ints.get(start), ints.get(end)) && chooseMaxIndex(ints, ints.get(start + 1), ints.get(end - 1)) != start + 1)
            return start;
        else
            return end;
    }

    private int chooseMaxIndex(List<Integer> ints, int start, int end) {
        if (end >= ints.size())
            return start;
        if (start == end)
            return start;
        if (ints.get(start).equals(ints.get(end)))
            return chooseMaxIndex(ints, start + 1, end - 1);
        if (ints.get(start) == Math.max(ints.get(start), ints.get(end)) && chooseMinIndex(ints, ints.get(start + 1), ints.get(end - 1)) != start + 1)
            return start;
        else
            return end;
    }
}
