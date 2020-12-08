package com.games.LeetCode.Problems.SingleNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testSingle() {
        assertEquals(1, new Solution().singleNumber(new int[]{2, 2, 1}));
    }

    @Test
    void testSingle2() {
        assertEquals(4, new Solution().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    @Test
    void testSingle3() {
        assertEquals(1, new Solution().singleNumber(new int[]{1}));
    }

}