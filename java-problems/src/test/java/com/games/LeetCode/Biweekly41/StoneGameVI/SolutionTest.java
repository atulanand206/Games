package com.games.LeetCode.Biweekly41.StoneGameVI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testStoneGame() {
        assertEquals(1, new Solution().stoneGameVI(new int[]{1, 3}, new int[]{2, 1}));
    }

    @Test
    void testStoneGame2() {
        assertEquals(0, new Solution().stoneGameVI(new int[]{1, 2}, new int[]{3, 1}));
    }

    @Test
    void testStoneGame3() {
        assertEquals(-1, new Solution().stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7}));
    }

}