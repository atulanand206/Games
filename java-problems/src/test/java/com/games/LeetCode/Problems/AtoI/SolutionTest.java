package com.games.LeetCode.Problems.AtoI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testConversion() {
        assertEquals(42, new Solution().myAtoi("42"));
    }

    @Test
    void testConversion2() {
        assertEquals(-42, new Solution().myAtoi("    -42"));
    }

    @Test
    void testConversion3() {
        assertEquals(4193, new Solution().myAtoi("4193 with words"));
    }

    @Test
    void testConversion4() {
        assertEquals(0, new Solution().myAtoi("words and 987"));
    }

    @Test
    void testConversion5() {
        assertEquals(-2147483648, new Solution().myAtoi("-91283472332"));
    }

    @Test
    void testConversion6() {
        assertEquals(2147483647, new Solution().myAtoi("5291283472332"));
    }

    @Test
    void testConversion7() {
        assertEquals(0, new Solution().myAtoi("-+12"));
    }

    @Test
    void testConversion8() {
        assertEquals(0, new Solution().myAtoi("+-12"));
    }

    @Test
    void testConversion9() {
        assertEquals(0, new Solution().myAtoi("+"));
    }

    @Test
    void testConversion10() {
        assertEquals(0, new Solution().myAtoi("00000-42a1234"));
    }

}