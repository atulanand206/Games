package com.games.LeetCode.Biweekly41.StoneGameVI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        if (aliceValues.length != bobValues.length)
            return 0;
        int length = aliceValues.length;

        List<Integer> scores = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < length; i++) {
            scores.add(aliceValues[i] + bobValues[i]);
            total += bobValues[i];
        }
        Collections.sort(scores);

        boolean aliceTurn = true;
        int av = 0;
        for (int i = length - 1; i >= 0; --i) {
            if (aliceTurn) {
                av += scores.get(i);
            }
            aliceTurn = !aliceTurn;
        }
        return Integer.compare(av, total);
    }
}
