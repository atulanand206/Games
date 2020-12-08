package com.games.LeetCode.Problems.SpiralOrder;

import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    void testSpiralOrder() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        List<Integer> list = new Solution().spiralOrder(matrix);
        System.out.println(combine(matrix));
        System.out.println(combine(result));
        System.out.println(combine(list));
    }

    @Test
    void testSpiralOrder2() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {6, 4, 5, 6}, {7, 8, 9, 12}};
        int[] result = {1, 2, 3, 6, 12, 9, 8, 7, 6, 4, 5};
        List<Integer> list = new Solution().spiralOrder(matrix);
        System.out.println(combine(matrix));
        System.out.println(combine(result));
        System.out.println(combine(list));
    }

    private String combine(int[][] arr) {
        StringBuilder st = new StringBuilder();
        for (int[] integer : arr) {
            st.append(combine(integer)).append("\n");
        }
        return st.toString();
    }

    private String combine(int[] arr) {
        StringBuilder st = new StringBuilder();
        for (int integer : arr) {
            st.append(integer).append(" ");
        }
        return st.toString();
    }

    private String combine(List<Integer> arr) {
        StringBuilder st = new StringBuilder();
        for (int integer : arr) {
            st.append(integer).append(" ");
        }
        return st.toString();
    }
}