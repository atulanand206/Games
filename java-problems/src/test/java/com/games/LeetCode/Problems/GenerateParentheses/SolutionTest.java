package com.games.LeetCode.Problems.GenerateParentheses;

import com.games.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class SolutionTest {

    @Test
    void testGenerateParentheses() {
        Utils.assertSameList(Collections.singletonList("()"), new Solution().generateParenthesis(1));
    }

    @Test
    void testGenerateParentheses2() {
        Utils.assertSameList(Arrays.asList("(())", "()()"), new Solution().generateParenthesis(2));
    }

    @Test
    void testGenerateParentheses3() {
        Utils.assertSameList(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"), new Solution().generateParenthesis(3));
    }

    @Test
    void testValidParentheses() {
        Assertions.assertTrue(new Solution().isValidParentheses("((()))"));
        Assertions.assertTrue(new Solution().isValidParentheses("(())()"));
        Assertions.assertFalse(new Solution().isValidParentheses("(())))"));
    }
}