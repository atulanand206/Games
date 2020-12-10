package com.games.LeetCode.DecChallenge.PairDuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testDuration() {
        assertEquals(3, new Solution().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    }

    @Test
    void testDuration2() {
        assertEquals(0, new Solution().numPairsDivisibleBy60(new int[]{439, 407, 197, 191, 291, 486, 30, 307, 11}));
    }

}