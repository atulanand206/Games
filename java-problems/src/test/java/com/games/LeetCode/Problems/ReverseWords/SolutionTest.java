package com.games.LeetCode.Problems.ReverseWords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testReverseWords() {
        assertEquals("blue is sky the", new Solution().reverseWords("the sky is blue"));
    }

    @Test
    void testReverseWords2() {
        assertEquals("world hello", new Solution().reverseWords("  hello world  "));
    }

    @Test
    void testReverseWords3() {
        assertEquals("example good a", new Solution().reverseWords("a good   example"));
    }

    @Test
    void testReverseWords4() {
        assertEquals("Alice Loves Bob", new Solution().reverseWords("  Bob    Loves  Alice   "));
    }

    @Test
    void testReverseWords5() {
        assertEquals("bob like even not does Alice", new Solution().reverseWords("Alice does not even like bob"));
    }

}