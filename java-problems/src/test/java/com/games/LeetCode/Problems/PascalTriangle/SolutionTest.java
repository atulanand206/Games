package com.games.LeetCode.Problems.PascalTriangle;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testPascal() {
        List<List<Integer>> generated = new Solution().generate(5);
        for (List<Integer> integers : generated) {
            for (Integer integer : integers)
                System.out.printf("%d  ", integer);
            System.out.println();
        }
    }

    @Test
    void testPascal2() {
        List<List<Integer>> generated = new Solution().generate(33);
        for (List<Integer> integers : generated) {
            for (Integer integer : integers)
                System.out.printf("%d  ", integer);
            System.out.println();
        }
    }

    @Test
    void testPascalRow() {
        List<Integer> generated = new Solution().getRow(3);
            for (Integer integer : generated)
                System.out.printf("%d ", integer);
            System.out.println();
    }

}