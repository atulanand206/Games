package com.games.LeetCode.Problems.MergeIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> lists = list2DOf(intervals);
        lists.sort(Comparator.comparing((List<Integer> l) -> {
            if (l.size() > 0)
                return l.get(0);
            return 0;
        }).thenComparing(l -> {
            if (l.size() > 1)
                return l.get(1);
            return 0;
        }));
        if (lists.isEmpty())
            return intervals;
        int start = 0, end = 1;
        while (end < lists.size() && start < lists.size()) {
            if (isMergeable(lists, start, end)) {
                List<Integer> merge = merge(lists, start, end);
                lists.set(start, merge);
                lists.remove(end);
            } else {
                start++;
                end++;
            }
        }
        return array2DOf(lists);
    }

    private boolean isMergeable(List<List<Integer>> lists, int start, int end) {
        if (lists.size() < start && lists.size() < end)
            return false;
        List<Integer> startList = lists.get(start);
        List<Integer> endList = lists.get(end);
        return startList.get(1) >= endList.get(0);
    }

    private List<Integer> merge(List<List<Integer>> lists, int start, int end) {
        List<Integer> startList = lists.get(start);
        List<Integer> endList = lists.get(end);
        List<Integer> result = new ArrayList<>();
        result.add(startList.get(0));
        result.add(Math.max(startList.get(1), endList.get(1)));
        return result;
    }

    private static List<List<Integer>> list2DOf(int[][] arrays) {
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

    private static int[][] array2DOf(List<List<Integer>> lists) {
        int[][] array = new int[lists.size()][];
        int i = 0;
        for (List<Integer> nestedList : lists) {
            Integer[] ts = nestedList.toArray(new Integer[nestedList.size()]);
            int[] tsi = new int[ts.length];
            for (int j = 0; j < tsi.length; j++)
                tsi[j] = ts[j];
            array[i++] = tsi;
        }
        return array;
    }
}
