package com.games.LeetCode.Weekly220.A;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testA() {
        assertEquals("123-456",new Solution().reformatNumber("1-23-45 6"));
    }

    @Test
    void testA2() {
        assertEquals("123-45-67",new Solution().reformatNumber("123 4-567"));
    }

    @Test
    void testA3() {
        assertEquals("123-456-78",new Solution().reformatNumber("123 4-5678"));
    }

    @Test
    void testA4() {
        assertEquals("12",new Solution().reformatNumber("12"));
    }

    @Test
    void testA5() {
        assertEquals("175-229-353-94-75",new Solution().reformatNumber("--17-5 229 35-39475 "));
    }

    @Test
    void testA6() {
        assertEquals("1",new Solution().reformatNumber("1"));
    }

    @Test
    void testA7() {
        assertEquals("99-64",new Solution().reformatNumber("9964-"));
    }

}