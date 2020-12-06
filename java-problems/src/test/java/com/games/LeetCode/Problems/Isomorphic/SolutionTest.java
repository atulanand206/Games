package com.games.LeetCode.Problems.Isomorphic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testIsomorphic() {
        assertTrue(new Solution().isIsomorphic("egg", "add"));
    }


    @Test
    void testIsomorphic2() {
        assertFalse(new Solution().isIsomorphic("foo", "bar"));
    }


    @Test
    void testIsomorphic3() {
        assertTrue(new Solution().isIsomorphic("paper", "title"));
    }

    @Test
    void testIsomorphic4() {
        assertFalse(new Solution().isIsomorphic("ab", "aa"));
    }

    @Test
    void testIsomorphic5() {
        assertTrue(new Solution().isIsomorphic("abab", "baba"));
    }

}