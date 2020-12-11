package com.games.LeetCode.Problems.VowelsInSubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testVowels() {
        assertEquals(3, new Solution().maxVowels("abciiidef", 3));
    }

    @Test
    void testVowels2() {
        assertEquals(2, new Solution().maxVowels("aeiou", 2));
    }

    @Test
    void testVowels3() {
        assertEquals(2, new Solution().maxVowels("leetcode", 3));
    }

    @Test
    void testVowels4() {
        assertEquals(0, new Solution().maxVowels("rhythms", 4));
    }

    @Test
    void testVowels5() {
        assertEquals(1, new Solution().maxVowels("tryhard", 4));
    }

    @Test
    void testIsVowel() {
        assertTrue(new Solution().isVowel('e'));
        assertTrue(new Solution().isVowel('a'));
        assertTrue(new Solution().isVowel('i'));
        assertTrue(new Solution().isVowel('o'));
        assertTrue(new Solution().isVowel('u'));
        assertFalse(new Solution().isVowel('p'));
    }
}