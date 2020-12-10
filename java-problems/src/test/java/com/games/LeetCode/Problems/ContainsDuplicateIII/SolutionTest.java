package com.games.LeetCode.Problems.ContainsDuplicateIII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testAlmostDuplicates() {
        assertTrue(new Solution().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        assertTrue(new Solution().containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        assertFalse(new Solution().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

}