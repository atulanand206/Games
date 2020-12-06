package com.games.LeetCode.Problems.FirstMissingPositive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testFirstMissing() {
        assertEquals(3, new Solution().firstMissingPositive(new int[]{1, 2, 0}));
    }

}