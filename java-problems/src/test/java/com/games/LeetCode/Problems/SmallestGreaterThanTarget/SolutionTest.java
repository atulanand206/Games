package com.games.LeetCode.Problems.SmallestGreaterThanTarget;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testTarget() {
        assertEquals('c', new Solution().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
    }

    @Test
    void testTarget2() {
        assertEquals('f', new Solution().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }

    @Test
    void testTarget3() {
        assertEquals('f', new Solution().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
    }

    @Test
    void testTarget4() {
        assertEquals('j', new Solution().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
    }

    @Test
    void testTarget5() {
        assertEquals('c', new Solution().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }

    @Test
    void testTarget6() {
        assertEquals('c', new Solution().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }
}