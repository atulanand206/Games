package com.games.LeetCode.DecChallenge.SpiralMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testSpiralMatrix() {
        Solution solution = new Solution();
        int[][] ints = solution.generateMatrix(5);
        for (int[] is : ints) {
            for (int i : is) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }

}