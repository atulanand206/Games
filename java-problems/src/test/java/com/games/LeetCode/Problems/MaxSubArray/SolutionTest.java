package com.games.LeetCode.Problems.MaxSubArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testMaxSubArray() {
        assertEquals(6, new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    void testMaxSubArray2() {
        assertEquals(1, new Solution().maxSubArray(new int[]{1}));
    }

    @Test
    void testMaxSubArray3() {
        assertEquals(0, new Solution().maxSubArray(new int[]{0}));
    }

    @Test
    void testMaxSubArray4() {
        assertEquals(-1, new Solution().maxSubArray(new int[]{-1}));
    }

    @Test
    void testMaxSubArray5() {
        assertEquals(-2147483647, new Solution().maxSubArray(new int[]{-2147483647}));
    }

    @Test
    void testMaxSubArray6() {
        assertEquals(1, new Solution().maxSubArray(new int[]{-2, 1}));
    }

    @Test
    void testKadane() {
        assertEquals(1, new Solution().maxSubArraySum(new int[]{-2, 1}));
    }

    @Test
    void testKadane2() {
        assertEquals(-1, new Solution().maxSubArraySum(new int[]{-2, -1}));
    }

}