package com.games.LeetCode.DecChallenge.CanPlaceFlowers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCanPlaceFlowers() {
        assertTrue(new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        assertFalse(new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    @Test
    void test103() {
        assertFalse(new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
    }
}