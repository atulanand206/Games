package com.games.LeetCode.WeeklyContest218.BinaryContatenation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testConcatenation() {
        assertEquals(1, new Solution().concatenatedBinary(1));
    }

    @Test
    void testConcatenation2() {
        assertEquals(27, new Solution().concatenatedBinary(3));
    }

    @Test
    void testConcatenation3() {
        String binaryString = Integer.toBinaryString(new Solution().concatenatedBinary(5));
        System.out.println(binaryString);
        assertEquals("11011100101", binaryString);
    }

    @Test
    void testConcatenation4() {
        assertEquals(505379714, new Solution().concatenatedBinary(12));
    }

}