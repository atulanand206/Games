package com.games.LeetCode.Problems.Palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testPalindrome() {
        assertTrue(new Solution().isPalindrome(121));
    }

    @Test
    void testPalindrome1() {
        assertFalse(new Solution().isPalindrome(-121));
    }

    @Test
    void testPalindrome3() {
        assertFalse(new Solution().isPalindrome(10));
    }

    @Test
    void testPalindrome4() {
        assertFalse(new Solution().isPalindrome(-101));
    }

}