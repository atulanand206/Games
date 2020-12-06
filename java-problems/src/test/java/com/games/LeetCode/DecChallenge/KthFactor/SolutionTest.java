package com.games.LeetCode.DecChallenge.KthFactor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    static Solution solution;

    @BeforeAll
    static void setup() {
        solution = new Solution();
    }

    @Test
    void testKthFactor1() {
        assertEquals(3, solution.kthFactor(12, 3));

    }

    @Test
    void testKthFactor2() {
        assertEquals(7, solution.kthFactor(7, 2));
    }

    @Test
    void testKthFactor3() {
        assertEquals(-1, solution.kthFactor(4, 4));
    }

    @Test
    void testKthFactor4() {
        assertEquals(1, solution.kthFactor(1, 1));
    }

    @Test
    void testKthFactor5() {
        assertEquals(4, solution.kthFactor(1000, 3));
    }
}