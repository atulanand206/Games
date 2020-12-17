package com.games.LeetCode.Problems.ValidVersions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution to LeetCode Problem #165. Compare Version Numbers
 * <p>
 * A version string is split at the dots and the items are parsed to an integer array.
 * While traversing from the beginning, {@link Integer#compare} is used to determine the difference.
 * If there is a difference encountered at any index, then the Integer comparison is returned.
 * If there is no difference, then the versions must be identical, hence 0 is returned.
 *
 * @author Atul Anand
 * @version 1.0 - 17th Dec 2020
 */
public class Solution {

    public int compareVersion(String version1, String version2) {
        List<Integer> v1Split = getVersionSplit(version1);
        List<Integer> v2Split = getVersionSplit(version2);
        fixListLength(v1Split, v2Split);
        return compareLists(v1Split, v2Split);
    }

    private int compareLists(List<Integer> v1Split, List<Integer> v2Split) {
        for (int i = 0; i < v1Split.size(); i++) {
            int compare = Integer.compare(v1Split.get(i), v2Split.get(i));
            if (compare != 0)
                return compare;
        }
        return 0;
    }

    private void fixListLength(List<Integer> v1Split, List<Integer> v2Split) {
        int size = Math.max(v1Split.size(), v2Split.size());
        while (v1Split.size() < size)
            v1Split.add(0);
        while (v2Split.size() < size)
            v2Split.add(0);
    }

    private List<Integer> getVersionSplit(String version1) {
        return intList(new ArrayList<>(Arrays.asList(version1.split("[.]"))));
    }


    private static List<Integer> intList(List<String> list) {
        List<Integer> result = new ArrayList<>();
        for (String str : list)
            result.add(Integer.parseInt(str));
        return result;
    }
}
