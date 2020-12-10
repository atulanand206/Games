package com.games.LeetCode.DecChallenge.MountainArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testMountainArray() {
        assertFalse(new Solution().validMountainArray(new int[]{2, 1}));
    }

    @Test
    void testMountainArray2() {
        assertFalse(new Solution().validMountainArray(new int[]{3, 5, 5}));
    }

    @Test
    void testMountainArray3() {
        assertTrue(new Solution().validMountainArray(new int[]{0, 3, 2, 1}));
    }

    @Test
    void testMountainArray4() {
        assertFalse(new Solution().validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
    }

    @Test
    void testMountainArray5() {
        assertFalse(new Solution().validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

}