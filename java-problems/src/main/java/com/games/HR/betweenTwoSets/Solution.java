package com.games.HR.betweenTwoSets;

import java.util.Collections;
import java.util.List;

public class Solution {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int nums = 0;
        for (int i = Collections.max(a); i <= Collections.min(b); i++) {
            int afs = 0;
            for (Integer ai : a) {
                if (i % ai == 0)
                    afs++;
            }
            int bfs = 0;
            for (Integer bi : b) {
                if (bi % i == 0)
                    bfs++;
            }
            if (afs == a.size() && bfs == b.size()) {
                nums++;
            }
        }
        return nums;
    }

}
