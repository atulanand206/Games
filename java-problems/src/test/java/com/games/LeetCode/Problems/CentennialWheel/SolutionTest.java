package com.games.LeetCode.Problems.CentennialWheel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCentennial() {
        assertEquals(3, new Solution().minOperationsMaxProfit(new int[]{8, 3}, 5, 6));
    }

    @Test
    void testCentennial2() {
        assertEquals(7, new Solution().minOperationsMaxProfit(new int[]{10, 9, 6}, 6, 4));
    }

    @Test
    void testCentennial3() {
        assertEquals(-1, new Solution().minOperationsMaxProfit(new int[]{3, 4, 0, 5, 1}, 1, 92));
    }

    @Test
    void testCentennial4() {
        assertEquals(9, new Solution().minOperationsMaxProfit(new int[]{10, 10, 6, 4, 7}, 3, 8));
    }

    @Test
    void testCentennial5() {
        assertEquals(5, new Solution().minOperationsMaxProfit(new int[]{10, 10, 1, 0, 0}, 4, 4));
    }

    @Test
    void testCentennial6() {
        assertEquals(9, new Solution().minOperationsMaxProfit(new int[]{10, 10, 6, 4, 7}, 3, 8));
    }

    @Test
    void testCentennial7() {
        assertEquals(307, new Solution().minOperationsMaxProfit(new int[]{
                        19, 42, 25, 18, 34, 24, 22, 11, 38, 33, 50, 33, 50, 26, 10, 4, 46, 5, 3, 50, 38, 20, 13, 1, 28,
                        6, 37, 11, 1, 9, 39, 13, 4, 14, 3, 39, 39, 0, 16, 11, 12, 16, 2, 28, 46, 33, 49, 43, 9, 23, 43, 40},
                35, 96));
    }

}