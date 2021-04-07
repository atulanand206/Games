package com.games.dP.ZigZagSubSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testZigZag() {
        assertEquals(6, new Solution().zigzag(new int[]{1, 7, 4, 9, 2, 5}));
        assertEquals(7, new Solution().zigzag(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        assertEquals(2, new Solution().zigzag(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}