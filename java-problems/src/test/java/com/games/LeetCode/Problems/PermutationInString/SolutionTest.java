package com.games.LeetCode.Problems.PermutationInString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCheckInclusion() {
        assertTrue(new Solution().checkInclusion("ab", "eidbaooo"));
    }

    @Test
    void testCheckInclusion2() {
        assertFalse(new Solution().checkInclusion("ab", "eidboaoo"));
    }
}