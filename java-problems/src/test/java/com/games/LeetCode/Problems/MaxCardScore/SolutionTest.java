package com.games.LeetCode.Problems.MaxCardScore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testCardScore() {
        assertEquals(12, new Solution().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }

    @Test
    void testCardScore2() {
        assertEquals(4, new Solution().maxScore(new int[]{2, 2, 2}, 2));
    }

    @Test
    void testCardScore3() {
        assertEquals(55, new Solution().maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    }

    @Test
    void testCardScore4() {
        assertEquals(1, new Solution().maxScore(new int[]{1, 1000, 1}, 1));
    }

    @Test
    void testCardScore5() {
        assertEquals(202, new Solution().maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }
}