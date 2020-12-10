package com.games.LeetCode.Problems.ContainsDuplicateII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testNearbyDuplicates() {
        assertTrue(new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        assertTrue(new Solution().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        assertFalse(new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

}