package com.games.LeetCode.Problems.JumpGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testJumpGame() {
        assertTrue(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    void testJumpGame2() {
        assertFalse(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    void testJumpGame3() {
        int[] nums = getInts();
        assertFalse(new Solution().canJump(nums));
    }

    private int[] getInts() {
        int[] ints = new int[25003];
        int j = 0;
        for (int i = 25000; i >= 1; i--, j++) {
            ints[j] = i;
        }
        ints[j++] = 1;
        ints[j++] = 0;
        ints[j] = 0;
        return ints;
    }
}