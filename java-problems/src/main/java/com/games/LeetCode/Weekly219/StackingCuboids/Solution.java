package com.games.LeetCode.Weekly219.StackingCuboids;

import com.games.chess.utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private boolean valid = true;

    public int maxHeight(int[][] cuboids) {
        List<List<Integer>> lists = list2DOf(cuboids);
        for (List<Integer> list : lists) {
            Collections.sort(list);
        }
        lists.sort((l1, l2) -> {
            if (l1.get(0) >= l2.get(1))
                return 1;
            if (l1.get(0) >= l2.get(2)) {
                Integer int1 = l2.get(1);
                Integer int2 = l2.get(2);
                l2.set(1, int2);
                l2.set(2, int1);
                return 1;
            }
            return l1.get(2).compareTo(l2.get(2));
        });
        for (int i = 0; i < lists.size() - 1; i++) {
            List<Integer> listI = lists.get(i);
            List<Integer> listI1 = lists.get(i + 1);
            if ((listI.get(0) > listI1.get(0) && listI.get(1) > listI1.get(1))
                    || (listI.get(0) < listI1.get(0) && listI.get(1) > listI1.get(1))
                    || (listI.get(0) > listI1.get(0) && listI.get(1) < listI1.get(1))) {
                valid = false;
                break;
            }
        }
        ListUtils.print2D(lists);
        if (valid) {
            int sum = 0;
            for (List<Integer> l : lists)
                sum += l.get(2);
            return sum;
        }
        return lists.get(lists.size() - 1).get(2);
    }

    public static List<List<Integer>> list2DOf(int[][] arrays) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] array : arrays) {
            List<Integer> list = new ArrayList<>();
            for (int anArray : array) {
                list.add(anArray);
            }
            lists.add(list);
        }
        return lists;
    }
}
