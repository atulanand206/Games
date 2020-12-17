package com.games.LeetCode.Problems.MaxProductSubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testMaxProductSubArray() {
        assertEquals(6, new Solution().maxProduct(new int[]{2, 3, -2, 4}));
    }

    @Test
    void testMaxProductSubArray2() {
        assertEquals(0, new Solution().maxProduct(new int[]{-2, 0, -1}));
    }

}