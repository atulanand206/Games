package com.games.LeetCode.Weekly219.CountMatches;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCountMatches() {
        Solution solution = new Solution();
        assertEquals(6, solution.numberOfMatches(7));
    }

    @Test
    void testCountMatches2() {
        Solution solution = new Solution();
        assertEquals(13, solution.numberOfMatches(14));
    }

}