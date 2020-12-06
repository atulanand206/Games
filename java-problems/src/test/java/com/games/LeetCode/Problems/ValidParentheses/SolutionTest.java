package com.games.LeetCode.Problems.ValidParentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testValid() {
        Solution solution = new Solution();
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("()[]{}"));
        assertTrue(!solution.isValid("(]"));
        assertTrue(!solution.isValid("([)]"));
        assertTrue(solution.isValid("{[]}"));
        assertTrue(!solution.isValid("]{[]}"));
    }

}