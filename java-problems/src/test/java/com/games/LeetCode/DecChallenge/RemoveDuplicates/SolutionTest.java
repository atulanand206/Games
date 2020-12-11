package com.games.LeetCode.DecChallenge.RemoveDuplicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testRemoval() {
        assertEquals(5, new Solution().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

    @Test
    void testRemoval2() {
        assertEquals(7, new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    @Test
    void testRemoval3() {
        assertEquals(5, new Solution().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

    @Test
    void testRemoval4() {
        assertEquals(2, new Solution().removeDuplicates(new int[]{1, 2}));
    }

}