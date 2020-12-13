package com.games.LeetCode.Problems.SingleNumberII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testSingleNumber() {
        assertEquals(3, new Solution().singleNumber(new int[]{2, 2, 3, 2}));
    }

}