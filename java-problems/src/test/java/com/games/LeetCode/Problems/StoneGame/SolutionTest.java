package com.games.LeetCode.Problems.StoneGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testStone() {
        assertTrue(new Solution().stoneGame(new int[]{5, 3, 4, 5}));
    }

}