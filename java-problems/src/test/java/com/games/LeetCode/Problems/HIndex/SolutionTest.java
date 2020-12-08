package com.games.LeetCode.Problems.HIndex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testHIndex() {
        assertEquals(3, new Solution().hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    @Test
    void testHIndex2() {
        assertEquals(4, new Solution().hIndex(new int[]{3, 0, 6, 3, 1, 5})); // 0 1 3 3 5 6
    }

    @Test
    void testHIndex3() {
        assertEquals(0, new Solution().hIndex(new int[]{0}));
    }

    @Test
    void testHIndex4() {
        assertEquals(1, new Solution().hIndex(new int[]{1}));
    }

    @Test
    void testHIndex5() {
        assertEquals(1, new Solution().hIndex(new int[]{100}));
    }

    @Test
    void testHIndex6() {
        assertEquals(0, new Solution().hIndex(new int[]{0, 0}));
    }
}