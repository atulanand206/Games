package com.games.LeetCode.Problems.ReverseInt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        assertEquals(321, new Solution().reverse(123));
        assertEquals(-321, new Solution().reverse(-123));
        assertEquals(153426369, new Solution().reverse(963624351));
    }
}