package com.games.LeetCode.Problems.MedianTwoSortedArrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testMedian() {
        Solution solution = new Solution();
        assertEquals(2.00000, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        assertEquals(2.50000, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    @Test
    void testCombineArray() {
        Solution solution = new Solution();
        int[] ints = solution.combineArrays(new int[]{1, 3}, new int[]{2});
        for (int i : ints)
            System.out.printf("%d ", i);
        System.out.println();
    }

    @Test
    void testCombineArray2() {
        Solution solution = new Solution();
        int[] ints = solution.combineArrays(new int[]{1, 2}, new int[]{3, 4});
        for (int i : ints)
            System.out.printf("%d ", i);
        System.out.println();
    }

}