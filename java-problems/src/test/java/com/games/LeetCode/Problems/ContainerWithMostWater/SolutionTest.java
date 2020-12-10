package com.games.LeetCode.Problems.ContainerWithMostWater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testMostWater() {
        assertEquals(49, new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void testMostWater2() {
        assertEquals(1, new Solution().maxArea(new int[]{1, 1}));
    }

    @Test
    void testMostWater3() {
        assertEquals(16, new Solution().maxArea(new int[]{4, 3, 2, 1, 4}));
    }

    @Test
    void testMostWater4() {
        assertEquals(2, new Solution().maxArea(new int[]{1, 2, 1}));
    }

}