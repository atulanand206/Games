package com.games.LeetCode.Biweekly41.ConsistentStrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testConsistent() {
        assertEquals(2, new Solution().countConsistentStrings("ab", new String[]{"ad","bd","aaab","baa","badab"}));
    }

    @Test
    void testConsistent2() {
        assertEquals(7, new Solution().countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"}));
    }

    @Test
    void testConsistent3() {
        assertEquals(4, new Solution().countConsistentStrings("cad", new String[]{"cc","acd","b","ba","bac","bad","ac","d"}));
    }

}