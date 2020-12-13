package com.games.LeetCode.Problems.StoneGame;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public boolean stoneGame(int[] piles) {
        List<Integer> collect = Arrays.stream(piles).boxed().sorted().collect(Collectors.toList());
        Collections.reverse(collect);
        int alex = 0;
        int lee = 0;
        boolean alexTurn = true;
        for (Integer in : collect) {
            if (alexTurn)
                alex += in;
            else
                lee += in;
            alexTurn = !alexTurn;
        }
        return alex > lee;
    }
}
