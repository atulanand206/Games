package com.games.LeetCode.Problems.ContainsDuplicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testContainsDuplicate() {
        assertTrue(new Solution().containsDuplicate(new int[]{1, 2, 3, 1}));
        assertTrue(new Solution().containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        assertFalse(new Solution().containsDuplicate(new int[]{1, 2, 3, 4}));
    }

}