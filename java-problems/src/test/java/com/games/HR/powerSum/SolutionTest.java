package com.games.HR.powerSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testPowerSum() {
        assertEquals(1, Solution.powerSum(10, 2));
    }

    @Test
    void testPowerSum2() {
        assertEquals(3, Solution.powerSum(100, 2));
    }

    @Test
    void testPowerSum3() {
        assertEquals(1, Solution.powerSum(100, 3));
    }

}