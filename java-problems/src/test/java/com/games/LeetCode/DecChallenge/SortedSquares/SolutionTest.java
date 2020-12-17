package com.games.LeetCode.DecChallenge.SortedSquares;

import com.games.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testSortedSquares() {
        Utils.assertSameArray(new int[]{0, 1, 9, 16, 100}, new Solution().sortedSquares(new int[]{-4, -1, 0, 3, 10}));
    }

    @Test
    void testSortedSquares2() {
        Utils.assertSameArray(new int[]{4, 9, 9, 49, 121}, new Solution().sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }
}