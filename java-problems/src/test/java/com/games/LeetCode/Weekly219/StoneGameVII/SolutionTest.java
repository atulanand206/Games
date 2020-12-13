package com.games.LeetCode.Weekly219.StoneGameVII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testStoneGameVII1() {
        Solution solution = new Solution();
        assertEquals(6, solution.stoneGameVII(new int[]{5, 3, 1, 4, 2}));
    }

    @Test
    void testStoneGameVII2() {
        Solution solution = new Solution();
        assertEquals(122, solution.stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }

}