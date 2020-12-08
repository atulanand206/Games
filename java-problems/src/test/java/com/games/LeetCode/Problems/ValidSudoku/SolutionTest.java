package com.games.LeetCode.Problems.ValidSudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testValid() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Solution solution = new Solution();
        int[][] topLeftVertices = solution.topLeftVertices;
        for (int[] topLeftVertex : topLeftVertices)
            assertTrue(solution.isBoxValid(board, topLeftVertex[0], topLeftVertex[1]));
        for (int i = 0; i < 9; i++)
            assertTrue(solution.isRowValid(board, i));
        for (int i = 0; i < 9; i++)
            assertTrue(solution.isColumnValid(board, i));
        assertTrue(solution.isValidSudoku(board));
    }

}