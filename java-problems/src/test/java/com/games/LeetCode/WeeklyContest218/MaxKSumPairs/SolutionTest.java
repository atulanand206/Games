package com.games.LeetCode.WeeklyContest218.MaxKSumPairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testKSumPairs() {
        assertEquals(2, new Solution().maxOperations(new int[]{1, 2, 3, 4}, 5));
    }

    @Test
    void testKSumPairs2() {
        assertEquals(1, new Solution().maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

}