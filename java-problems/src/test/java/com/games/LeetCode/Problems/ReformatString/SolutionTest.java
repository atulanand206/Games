package com.games.LeetCode.Problems.ReformatString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testReformat() {
        assertEquals("c2o0v1i9d", new Solution().reformat("covid2019"));
    }

}