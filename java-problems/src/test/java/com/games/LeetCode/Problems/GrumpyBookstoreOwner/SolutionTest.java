package com.games.LeetCode.Problems.GrumpyBookstoreOwner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testGrumpy() {
        assertEquals(16, new Solution().maxSatisfied(
                new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
        // 2 8
        // 3 9
        // 4 8
        // 4 9
        // 9 2
        // 13 3
    }

}