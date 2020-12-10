package com.games.LeetCode.Problems.ZigZagConversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testZigZag() {
        assertEquals("PAHNAPLSIIGYIR", new Solution().convert("PAYPALISHIRING", 3));
    }

    @Test
    void testZigZag2() {
        assertEquals("PINALSIGYAHRPI", new Solution().convert("PAYPALISHIRING", 4));
    }

    @Test
    void testZigZag3() {
        assertEquals("A", new Solution().convert("A", 1));
    }

    @Test
    void testZigZag4() {
        assertEquals("ABCED", new Solution().convert("ABCDE", 4));
    }

    @Test
    void testZigZag5() {
        assertEquals("PHASIYIRPLIGAN", new Solution().convert("PAYPALISHIRING", 5));
    }

}