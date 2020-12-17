package com.games.LeetCode.Problems.ValidVersions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testValidVersion() {
        assertEquals(-1, new Solution().compareVersion("7.5.2.4", "7.5.3"));
    }

    @Test
    void testValidVersion2() {
        assertEquals(0, new Solution().compareVersion("1.01", "1.001"));
    }

    @Test
    void testValidVersion3() {
        assertEquals(0, new Solution().compareVersion("1.0", "1.0.0"));
    }

    @Test
    void testValidVersion4() {
        assertEquals(-1, new Solution().compareVersion("0.1", "1.1"));
    }

    @Test
    void testValidVersion5() {
        assertEquals(1, new Solution().compareVersion("1.0.1", "1"));
    }

}