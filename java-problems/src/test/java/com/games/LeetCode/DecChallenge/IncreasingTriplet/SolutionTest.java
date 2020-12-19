package com.games.LeetCode.DecChallenge.IncreasingTriplet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testIncreasing() {
        assertTrue(new Solution().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testIncreasing2() {
        assertFalse(new Solution().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void testIncreasing3() {
        assertTrue(new Solution().increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

}