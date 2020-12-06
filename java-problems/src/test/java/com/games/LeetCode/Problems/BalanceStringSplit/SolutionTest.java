package com.games.LeetCode.Problems.BalanceStringSplit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testBalanceSplit() {
        Solution solution = new Solution();
        assertEquals(4, solution.balancedStringSplit("RLRRLLRLRL"));
        assertEquals(3, solution.balancedStringSplit("RLLLLRRRLR"));
        assertEquals(1, solution.balancedStringSplit("LLLLRRRR"));
        assertEquals(2, solution.balancedStringSplit("RLRRRLLRLL"));
    }

}