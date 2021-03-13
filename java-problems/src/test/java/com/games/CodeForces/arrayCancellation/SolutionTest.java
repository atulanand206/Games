package com.games.CodeForces.arrayCancellation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    void testArrayCancellation() {
        Assertions.assertEquals(3, Solution.cancellation(new int[]{-3, 5, -3, 1}));
        Assertions.assertEquals(0, Solution.cancellation(new int[]{1, -1}));
        Assertions.assertEquals(1, Solution.cancellation(new int[]{-1, 1, 1, -1}));
        Assertions.assertEquals(0, Solution.cancellation(new int[]{0}));
        Assertions.assertEquals(4, Solution.cancellation(new int[]{-3, 2, -3, 4}));
        Assertions.assertEquals(8, Solution.cancellation(new int[]{-5, 7, -6, -4, 17, -13, 4}));
        Assertions.assertEquals(3000000000L, Solution.cancellation(new int[]{-1000000000, -1000000000, -1000000000, 1000000000, 1000000000, 1000000000}));
    }
}
