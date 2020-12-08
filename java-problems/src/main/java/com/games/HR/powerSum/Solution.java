package com.games.HR.powerSum;

import com.games.chess.utils.ListUtils;

import java.util.*;

public class Solution {

    public static int powerSum(int X, int N) {
        List<Integer> possibleItems = new ArrayList<>();
        int abscissa = 1;
        while (Math.pow(abscissa, N) < X)
            possibleItems.add((int) Math.pow(abscissa++, N));
        return choose(X, possibleItems);
    }

    private static int choose(int x, List<Integer> items) {
        ListUtils.print(items);
        return 1;
    }

}
