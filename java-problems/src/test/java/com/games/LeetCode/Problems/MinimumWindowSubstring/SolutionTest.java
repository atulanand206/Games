package com.games.LeetCode.Problems.MinimumWindowSubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testMinWindow() {
        assertEquals("BANC", new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void testMinWindow2() {
        assertEquals("a", new Solution().minWindow("a", "a"));
    }
}